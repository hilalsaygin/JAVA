package homework8;

import java.util.*;

public class CSE222Dijkstra {
    CSE222Graph graph ;
    List<CSE222Graph.Node> sortest=new ArrayList<>() ;

    PriorityQueue<CSE222Graph.Node> priorityQueue;
    CSE222Dijkstra(CSE222Graph graph){
        this.graph=graph;
    }

    public List<CSE222Graph.Node> findPath() {
        // Initialize distances and previous nodes
        Map<CSE222Graph.Node, Integer> distances = new HashMap<>();
        Map<CSE222Graph.Node, CSE222Graph.Node> previousNodes = new HashMap<>();
        for (CSE222Graph.Node node : graph.graphNodes) {
            distances.put(node, Integer.MAX_VALUE);
            previousNodes.put(node, null);
        }

        // Set distance of start node to 0
        CSE222Graph.Node startNode = graph.getNode(graph.startCords[0], graph.startCords[1]);
        distances.put(startNode, 0);

        // Create a priority queue for nodes based on their distances
        PriorityQueue<CSE222Graph.Node> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        queue.add(startNode);

        while (!queue.isEmpty()) {
            CSE222Graph.Node current = queue.poll();

            // Stop if the current node is the end node
            if (current.x() == graph.endCords[0] && current.y() == graph.endCords[1]) {
                break;
            }

            // Explore neighbors
            for (CSE222Graph.Node neighbor : current.neighbors) {
                int distance = distances.get(current) + 1; // Assuming all edges have weight 1
                if(neighbor !=null) {


                    if (distance < distances.get(neighbor)) {
                        distances.put(neighbor, distance);
                        previousNodes.put(neighbor, current);
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        // Reconstruct the shortest path
        List<CSE222Graph.Node> shortestPath = new ArrayList<>();
        CSE222Graph.Node currentNode = graph.getNode(graph.endCords[0], graph.endCords[1]);
        while (currentNode != null) {
            shortestPath.add(0, currentNode);
            currentNode = previousNodes.get(currentNode);
        }
        if (shortestPath.size()==0){
            System.out.println("No feasible path is found.");
            return  null;
        }
        sortest.addAll(shortestPath);
        return shortestPath;
    }
    public void displayShortest(){
        for (CSE222Graph.Node nd: this.sortest){
            System.out.println(nd.getCords() +"**");
        }
    }

}
