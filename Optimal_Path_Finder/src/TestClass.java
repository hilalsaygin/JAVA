package homework8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestClass {
    static String  currDir=System.getProperty("user.dir");

    public static void main(String[] args) throws Exception {
        //takes map name as command lineargument and creates a map then from map creates a graph object.
        //on created grap object apply bfs ad dijkstra algoriths to find feasible paths between start en end po,nts on ap which are provided in txt file.
        //after f,nd,ng feas,ble paths on map , convert provided map to png then draws paths found from bfs and dijkstra on separate png files
        System.out.println(args[0]);
        String filepath= currDir+ "\\inputs\\" +args[0];
        //Create map objects
        

        CSE222Map map = new CSE222Map (filepath);
        CSE222Graph graph =new CSE222Graph(map);
        String directoryPath = currDir+"\\outputs\\";        
        Path path = Paths.get(directoryPath);
        String bfsdir = currDir+"\\outputs\\bfs\\";        
    
        Path bfspath = Paths.get(bfsdir);
        String djdir = currDir+"\\outputs\\dijkstra\\";        
        Path djpath = Paths.get(djdir);

        try {
            Files.createDirectory(path);
            Files.createDirectories(djpath);
            Files.createDirectories(bfspath);
            System.out.println("Directory created successfully.");
            

        } catch (IOException e) {

           // System.out.println("Directory already exist: " + e.getMessage());
        }
           
        CSE222BFS BFS = new CSE222BFS(graph);
        List<CSE222Graph.Node> BFSPath = BFS.findPath();
        map.setFilePath(bfsdir);
        map.convertPNG();
        map.drawLine(BFSPath);
        map.writePath(BFSPath);

        CSE222Dijkstra Dijkstra  = new CSE222Dijkstra(graph);
        List<CSE222Graph.Node> DijkstraPath = Dijkstra.findPath();
        map.setFilePath(djdir);
        map.convertPNG();
        map.drawLine(DijkstraPath);
        map.writePath(DijkstraPath);


    }
   

}
