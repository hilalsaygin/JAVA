package homework8;

import java.util.*;

public class CSE222Graph {
    ArrayList<Node> graphNodes= new ArrayList<>();
    int[] startCords; //index zero is the row, index 1 column
    int[] endCords;
    private ArrayList<String> created=new ArrayList<>();
    private CSE222Map graphMap;

    class Node{
        int x;
        int y;
        ArrayList<Node> neighbors=new ArrayList<>();
        public ArrayList<Node> path = new ArrayList<Node>();


        public int x() {
            return x;
        }

        public int y() {
            return y;
        }
        /**
         * The function returns the coordinates of an object as a string in the format "x,y".
         * 
         * @return A string containing the values of the variables x and y separated by a comma.
         */
        public String getCords(){
            return x+","+y;
        }
        /**
         * The function returns an integer array containing the x and y coordinates.
         * 
         * @return An integer array containing the values of x and y.
         */
        public int[] getCordsArr(){
            int[] temp = new int[2];
            temp[0]=x;
            temp[1]=y;
            return temp;
        }


        // This is a constructor for the `Node` class that takes two integer parameters `x` and `y`. It
        // sets the `x` and `y` instance variables of the `Node` object to the values of the `x` and
        // `y` parameters, respectively.
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }

        /**
         * The function returns an ArrayList of Node objects representing a path.
         * 
         * @return An ArrayList of Node objects named "path" is being returned.
         */
        public ArrayList<Node> path() {
            return path;
        }
        /**
         * This Java function displays the coordinates of each node in a path.
         */
        public void displayPath(){
            for (Node nd: this.path){
                System.out.println(nd.getCords() +" - ");

            }
            System.out.println("***********");
        }

        /**
         * The function adds a node's neighbor to its list of neighbors.
         * 
         * @param neighCords neighCords is an object of the Node class that represents the coordinates
         * of a neighboring node. The method addNeighbor adds this neighboring node to the list of
         * neighbors of the current node.
         */
        void addNeighbor(Node neighCords){
            this.neighbors.add(neighCords);

        }
        /**
         * This function adds a node to a path if it does not already exist in the path.
         * 
         * @param nd nd is a parameter of type Node that represents the node that needs to be added to
         * the path.
         */
        public void addToPath(Node nd){
            if( ! isExist(nd))
                path.add(nd);
        }
        /**
         * This function displays the x and y coordinates of each neighbor node in a list.
         */
        private void  displayNeighbors(){
            for(Node neigh: neighbors){
                System.out.print(neigh.x() + ":" + neigh.y() + "  ");
            }

        }

    }
    /**This is a constructor for the `CSE222Graph` class that takes a `CSE222Map` object as input. It
    * sets the `graphMap` instance variable to the input `mapIn`, and initializes the `startCords` and
    * `endCords` arrays with the start and end coordinates from the `graphMap`. It then calls the
    * `createGraph` method to create the graph representation of the map.
    */
    public CSE222Graph(CSE222Map mapIn) {
        this.graphMap =mapIn;
        startCords= graphMap.startCords().clone();
        endCords= graphMap.endCords().clone();
        createGraph(graphMap);
    }
    public CSE222Map graphMap(){
        return graphMap;
    }
    /**
     * The function checks if a node exists in its own path by comparing its coordinates with the
     * coordinates of other nodes in the path.
     * 
     * @param nd The parameter "nd" is a Node object that is being checked for existence in its own
     * path. The method "isExist" is checking if the Node object "nd" already exists in its own path by
     * comparing its x and y coordinates with the x and y coordinates of each Node object in its
     * @return The method `isExist` returns a boolean value. It returns `true` if the input `Node`
     * object `nd` already exists in the path of any of its ancestor nodes, and `false` otherwise.
     */
    private boolean isExist(Node nd){
        for ( Node node: nd.path()){
            if(node.x() == nd.x() && node.y() == nd.y())
                return true;
        }
        return false;
    }


    
 /**
  * This function creates a graph by iterating through each cell in a matrix and adding neighboring
  * nodes to each node that represents an available cell.
  * 
  * @param mapIn a CSE222Map object that contains a matrix representing a map with obstacles and a
  * starting point. The method creates a graph representation of the map using the matrix and stores it
  * in the object.
  */
    private void createGraph(CSE222Map mapIn){
        //then iterate over matrix and create vertices with the list of available adjacent entries
    //for efficiency in time and space, coordinates of vertex kept in string and the list of adjacency list is arraylist
        newGraph(mapIn);
        // Iterate through each cell in the matrix starting from start point coordinates
        for (int i = mapIn.startCords[0]; i < mapIn.n(); i++) { //rows
            for (int j = mapIn.startCords[1]; j < mapIn.n(); j++) { //columns
                // Check if the cell is available (0)
                //if available store the entry cooardinates in map
                if (mapIn.matrix[i][j] == 0) {
                    Node current = getNode(i,j);
                    if(current == null){
                        System.out.println("Node cannot found!!");
                        System.exit(0);
                    }
                    //if first node add itself as root
                    if(current.path().size()==0){
                        current.addToPath(current);
                    }
                    //current.displayPath();
                    //ArrayList<String> neighbors = new ArrayList<>();
                    // i-1 , j Top
                    if ((i > 0) && mapIn.matrix[i - 1][j] == 0) {
                        Node neighbor = getNode(i-1,j);
                        current.addNeighbor(neighbor);
                    }
                    //i+1, j Bottom
                    if ((i + 1 < mapIn.n()) && mapIn.matrix[i + 1][j] == 0) {
                        Node neighbor= getNode(i+1,j);
                        current.addNeighbor(neighbor);
                    }
                    // i, j-1 left
                    if ((j > 0) && mapIn.matrix[i][j - 1] == 0) {
                        Node neighbor= getNode(i,j-1);
                        current.addNeighbor(neighbor);
                    }
                    // i, j+1 Right
                    if ((j + 1 < mapIn.n()) && mapIn.matrix[i][j + 1] == 0) {
                        String neighCords = (i) + "," + (j + 1);
                    }
                    //i-1 , j-1 diagonal left top
                    if ((i > 0 && j >0) && mapIn.matrix[i - 1][j - 1] == 0) {
                        Node neighbor= getNode(i-1,j-1);
                        current.addNeighbor(neighbor);
                    }
                    //i-1 , j+1 diagonal right top
                    if ((i > 0 && j +1 < mapIn.n()) && mapIn.matrix[i - 1][j + 1] == 0) {
                        Node neighbor= getNode(i-1,j+1);
                        current.addNeighbor(neighbor);
                    }
                    //i+1 , j+1 diagonal right bottom
                    if ((i+1 < mapIn.n() && j +1 < mapIn.n()) && mapIn.matrix[i + 1][j + 1] == 0) {
                        Node neighbor= getNode(i+1,j+1);
                        current.addNeighbor(neighbor);
                    }
                    //i+1 , j-1 diagonal left bottom
                    if ((i + 1 < mapIn.n() && j > 0) && mapIn.matrix[i + 1][j - 1] == 0) {
                        Node neighbor= getNode(i+1,j-1);
                        current.addNeighbor(neighbor);
                    }
                }
            }
        }
       
    }
    /**
     * The function creates a new graph by iterating through a matrix and adding nodes to the graph for
     * each available cell.
     * 
     * @param mapIn a CSE222Map object that contains a matrix representing a map/grid. The method is
     * iterating through the matrix to find cells that are available (represented by 0) and adding them
     * as nodes to a graph.
     */
    private void newGraph(CSE222Map mapIn){
        for (int i = mapIn.startCords[0]; i < mapIn.n(); i++) { //rows
            for (int j = mapIn.startCords[1]; j < mapIn.n(); j++) { //columns
                // Check if the cell is available (0)
                //if available store the entry cooardinates in map
                if (mapIn.matrix[i][j] == 0) {
                    if (!created.contains(i + "," + j)) {
                        created.add(i + ",+j");
                        addNode(i, j);
                    }
                }
            }
        }
    }
    /**
     * This Java function searches for a node in a list of graph nodes based on its x and y
     * coordinates.
     * 
     * @param x The x-coordinate of the node being searched for in the graph.
     * @param y The parameter "y" in the method signature refers to the y-coordinate of a node in a
     * graph. The method is searching for a node in the graph that has the specified x and y
     * coordinates.
     * @return The method `getNode` returns a `Node` object that matches the given `x` and `y`
     * coordinates. If there is no such node in the `graphNodes` list, it returns `null`.
     */
    protected Node getNode(int x, int y){
        for(Node curr: graphNodes){
            if(curr.x() == x && curr.y() == y)
                return curr;
        }
        return null;
    }
    /**
     * This function adds a new node to a graph representation.
     * 
     * @param x The x-coordinate of the node being added to the graph.
     * @param y The parameter "y" in the method "addNode" represents the y-coordinate of the node being
     * added to the graph.
     */
    private void addNode(int x, int y){
        Node newNode = new Node(x,y);
        //add vertex to map which is graph representation
        graphNodes.add(newNode);
    }
    /**
     * This function displays the nodes and their neighbors in a graph.
     */
    public void displayGraph(){
        for( Node entry : graphNodes ){
            System.out.print( (entry.x()) +":"+ entry.y() + " = " );
            entry.displayNeighbors();
            System.out.println();
        }
    }


}
