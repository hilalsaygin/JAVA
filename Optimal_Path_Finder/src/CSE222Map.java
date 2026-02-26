package homework8;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Takes map filepath as input string and read the file. Then constructs a map from file input.
 * File content is separated from comma and stored into 2d array.
 *
 */
public class CSE222Map {
    protected  int[] startCords= new int[2]; //index zero is the row, index 1 column
    protected  int[] endCords= new int[2];
    public int[][] matrix = new int[0][0];
    private int n;

    BufferedImage pngImage;
    Graphics2D graphics;
    String filePath ;
    String mapName ;


    /**
     * This function sets the file path for a Java object.
     * 
     * @param filePath filePath is a variable of type String that represents the path of a file. The
     * method setFilePath sets the value of the instance variable filePath to the value passed as a
     * parameter.
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int n() {
        return n;
    }

    /**
     * The function returns an integer array representing the starting coordinates.
     * 
     * @return An integer array called "startCords".
     */
    public int[] startCords() {
        return startCords;
    }

    /**
     * The function "endCords" returns an integer array.
     * 
     * @return An integer array called "endCords".
     */
    public int[] endCords() {
        return endCords;
    }

    // This is a constructor for the `CSE222Map` class that takes a file path as input and initializes
    // the `filePath` variable with it. It then extracts the name of the file from the file path and
    // initializes the `mapName` variable with it. Finally, it calls the `readFile` method to read the
    // contents of the file and construct a map from it. If any exception occurs during the file
    // reading process, it throws an `Exception`.
    public CSE222Map(String inputFile) throws Exception {
        filePath=inputFile;
        String[] temp =filePath.split("\\\\");
        mapName = temp[temp.length-1].split("\\.")[0];
        readFile(inputFile);

    }

    /**
     * This function reads a file containing a matrix of integers and extracts the start and end
     * coordinates, while also checking if they are valid.
     * 
     * @param filePath The file path of the input file to be read.
     */
    private void readFile(String filePath) throws Exception {
        // pass the path to the file as a parameter
        FileInputStream file = new FileInputStream(filePath);
        try {
            Scanner scan  = new Scanner(file);
            String[] start  = scan.nextLine().split(",");
            String[] end  = scan.nextLine().split(",");
            //System.out.println(Arrays.toString(start) + " ----" + Arrays.toString(end));
            startCords[0] = Integer.parseInt(start[0]);
            startCords[1] = Integer.parseInt(start[1]);
            endCords[0]   = Integer.parseInt(end[0]);
            endCords[1]   = Integer.parseInt(end[1]);
            //System.out.println("Cords: " + Arrays.toString(startCords) + "**" + Arrays.toString(endCords));
            //read first line
            String[] firstline = scan.nextLine().split(",");
            this.n= firstline.length;
            if(startCords[0] > n || startCords[1]> n){
                System.out.println("Invalid start point coordinates");
            }
            //declare 2d array memory according to value count in the first line
            if(matrix.length == 0)
                matrix = new int[n][n];
            //append first line to 2d matrix. While appending from string array convert to int
            for (int j=0; j< n; j++){
                if(firstline[j].trim().equals("-1"))
                    matrix[0][j] = 1 ;
                else
                    matrix[0][j] = Integer.parseInt(firstline[j].trim());
            }
            int row=1;
            while (scan.hasNextLine()){
                String[] line = scan.nextLine().split(",");
                //append each line to 2d matrix. While appending from string array convert to int
                for (int j=0; j< n ; j++){
                    if(line[j].trim().equals("-1"))
                        matrix[row][j] = 1;
                    else
                        matrix[row][j] = Integer.parseInt(line[j].trim());
                }
                row++;
            }
            file.close();
        }catch (FileNotFoundException ex){
            System.out.println(ex);
            System.exit(0);
        }
        if(matrix[startCords[0]][startCords[1]] != 0)
            throw new Exception("Start Point is not available !!");
        if(matrix[endCords[0]][endCords[1]] != 0)
            throw new Exception("Target Point is not available !!");

    }
    /**
     * The function converts a matrix into a PNG image by drawing each element of the matrix as a pixel
     * with a corresponding color.
     */
    protected void convertPNG(){

        this.pngImage = new BufferedImage(n, n, BufferedImage.TYPE_INT_ARGB);
        graphics = pngImage.createGraphics();

        // Draw each element of the matrix as a pixel
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int pixelValue = matrix[row][col];
                Color color = (pixelValue == 1) ? Color.WHITE : Color.GRAY;
                graphics.setColor(color);
                graphics.fillRect(col, row, 1, 1);
            }
        }
        

    }
    /**
     * This function draws a red line on a map image connecting a list of nodes and saves the modified
     * image to a file.
     * 
     * @param pathList A list of nodes representing the path to be drawn on the map image.
     */
    protected void drawLine(List<CSE222Graph.Node> pathList){

        if(pathList == null){
            System.out.println("No path");
            System.exit(0);
        }
        // Set line color and thickness
        graphics.setColor(Color.RED);
        graphics.setStroke(new BasicStroke(2));

        // Define the feasible path coordinates
        ArrayList<int[]> pathCoordinates = new ArrayList<>();
        for (CSE222Graph.Node nd: pathList){
            pathCoordinates.add(nd.getCordsArr());
        }

        // Draw the line on the map image
        for (int i = 0; i < pathCoordinates.size()-1; i++) {
            int[] start = pathCoordinates.get(i);
            int[] end = pathCoordinates.get(i +1);
            graphics.drawLine(start[1], start[0], end[1], end[0]);
        }
        graphics.dispose();


        // Save the modified map image to a file
        try {
            String fileOut = filePath +mapName+".png";
            File output = new File(fileOut);
            ImageIO.write(pngImage, "png", output);
            System.out.println("Map image with line drown saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving map image : " + e.getMessage());
        }


    }
    /**
     * This function writes a list of coordinates to a text file.
     * 
     * @param pathList A list of nodes representing a path in a graph.
     */
    protected void writePath(List<CSE222Graph.Node> pathList){

        try {
            String fileOut = filePath+ mapName+"_path.txt";
            FileWriter fWrite = new FileWriter(fileOut);
            for (int i = 0; i < pathList.size(); i++) {
                fWrite.write(pathList.get(i).getCords()+"\n");
            }
            fWrite.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred during writing to output file!!");
            e.printStackTrace();
        }

    }

}
