package homework8;

import java.util.*;

public class CSE222BFS {
    CSE222Graph graph;
    private Set<CSE222Graph.Node> visited = new HashSet<>(); //Stores visited node coordinates
    ArrayList<ArrayList<CSE222Graph.Node>> finalPaths =new ArrayList<>();

    public CSE222BFS(CSE222Graph graph){
        this.graph=graph;
    }
    public List<CSE222Graph.Node> findPath() {


        Queue<CSE222Graph.Node> queue = new LinkedList<>();
        //add first node in graph list
        CSE222Graph.Node first=(graph.getNode(graph.startCords[0], graph.startCords[1]));
        queue.add(first);
        visited.add(first);
        first.addToPath(first);

        while (!queue.isEmpty()) {
            CSE222Graph.Node current = queue.poll();
            if ( (current.x() == graph.endCords[0]) && current.y() == graph.endCords[1] ) {
                //buildPath(current);
                //current.displayPath();
                Collections.reverse(current.path);
                return current.path;
            }

            for (CSE222Graph.Node neighbor : current.neighbors) {
                if(neighbor != null) {

                    if (!visited.contains(neighbor)) {
                        neighbor.path().addAll(current.path());
                        neighbor.addToPath(neighbor);
                        queue.add(neighbor);
                        visited.add(neighbor);

                    }
                }
            }
        }
        //System.out.println("No feasible path is found.");
        return null;
    }
    public void displayPath(){
        for (ArrayList<CSE222Graph.Node> nd: finalPaths){
            System.out.println(nd.toString() + "***");
        }
    }
    private void buildPath(CSE222Graph.Node node){
        finalPaths.add(node.path());

    }

}
