package homework8;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class TestClassM1 {
    static AbstractList<CSE222Graph> graphObjects = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        String currDir=System.getProperty("user.dir");
        //String currDir+"\\inputs\\" +"map1.txt"=currDir+"\\src\\inputs\\" +"map10.txt";
        //Create map objects
        CSE222Map map1 = new CSE222Map (currDir+"\\inputs\\" +"map1.txt");
        CSE222Map map2 = new CSE222Map (currDir+"\\inputs\\" +"map2.txt");
        CSE222Map map3 = new CSE222Map (currDir+"\\inputs\\" +"map3.txt");
        CSE222Map map4 = new CSE222Map (currDir+"\\inputs\\" +"map4.txt");
        CSE222Map map5 = new CSE222Map (currDir+"\\inputs\\" +"map5.txt");
        CSE222Map map6 = new CSE222Map (currDir+"\\inputs\\" +"map6.txt");
        CSE222Map map7 = new CSE222Map (currDir+"\\inputs\\" +"map7.txt");
        CSE222Map map8 = new CSE222Map (currDir+"\\inputs\\" +"map8.txt");
        CSE222Map map9 = new CSE222Map (currDir+"\\inputs\\" +"map9.txt");
        CSE222Map map10 = new CSE222Map (currDir+"\\inputs\\" +"map10.txt");
        CSE222Map pisa = new CSE222Map (currDir+"\\inputs\\" +"pisa.txt");
        CSE222Map tokyo = new CSE222Map (currDir+"\\inputs\\" +"tokyp.txt");
        CSE222Map triumph = new CSE222Map (currDir+"\\inputs\\" +"triumph.txt");
        CSE222Map vatican = new CSE222Map (currDir+"\\inputs\\" +"vatican.txt");
        //create grap object and store into arraylist for easy access
        createGraphs(map1);
        createGraphs(map2);
        createGraphs(map3);
        createGraphs(map4);
        createGraphs(map5);
        createGraphs(map6);
        createGraphs(map7);
        createGraphs(map8);
        createGraphs(map9);
        createGraphs(map10);
        createGraphs(pisa);
        createGraphs(tokyo);
        createGraphs(triumph);
        createGraphs(vatican);
        try {
            for( CSE222Graph grp : graphObjects){
                applyBFS(grp);
            }
        }catch (NullPointerException ex){
            System.out.println("No feasible path on map !!");
        }

        /*
        //apply bfs on graph object

        CSE222Graph graph1 =new CSE222Graph(map1);
        CSE222BFS BFS = new CSE222BFS(graph1);
        CSE222Dijkstra Dijkstra = new CSE222Dijkstra (graph1);

        List<CSE222Graph.Node> BFSPath = BFS.findPath();
//        List<CSE222Graph.Node> DijkstraPath=Dijkstra.findPath();
        //BFS.displayPath();
        try {
            map1.convertPNG();
  //          map1.drawLine(DijkstraPath);
            map1.drawLine(BFSPath);
            map1.writePath(BFSPath);
    //        map1.writePath(DijkstraPath);

        }catch (NullPointerException ex){
            System.out.println("No feasible path on map !!");
        }

        System.out.println("Dijkstra Path: "+ DijkstraPath.size());
        System.out.println("BFS Path: "+ BFSPath.size());

        System.out.println(DijkstraPath.toString());
        BFS.displayPath();
        Dijkstra.displayShortest();

         */


    }
    private static void createGraphs(CSE222Map mp){
        CSE222Graph newGrp = new CSE222Graph(mp);
        graphObjects.add(newGrp);
    }
    private static void applyBFS(CSE222Graph Graph){
        String currDir=System.getProperty("user.dir");
        CSE222BFS BFS = new CSE222BFS(Graph);
        List<CSE222Graph.Node> BFSPath = BFS.findPath();
        Graph.graphMap().setFilePath(currDir+"\\bfs\\");
        Graph.graphMap().drawLine(BFSPath);
        Graph.graphMap().writePath(BFSPath);

    }
    private  static  void applyDijkstra(CSE222Graph Graph){
        String currDir=System.getProperty("user.dir");
        CSE222Dijkstra Dijkstra  = new CSE222Dijkstra(Graph);
        List<CSE222Graph.Node> DijkstraPath = Dijkstra.findPath();
        Graph.graphMap().setFilePath(currDir+"\\dijkstra\\");
        Graph.graphMap().drawLine(DijkstraPath);
        Graph.graphMap().writePath(DijkstraPath);

    }
}
