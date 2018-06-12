
import java.util.*;

public class PendingMainGraphP {
//    public static void main(String[] args) {
//        Graph graph = new Graph();
//        graph.addConnection(1, 2);
//        graph.addConnection(1, 3);
//        graph.addConnection(3, 4);
//        graph.addConnection(4, 5);
//        graph.addConnection(4, 6);
//        graph.addConnection(4, 7);
//        graph.addConnection(3, 8);
//        graph.addConnection(6, 9);
//        graph.addConnection(8, 9);
//        graph.addConnection(7, 8);
//
//        graph.printG();
//
//        BFS bfs = new BFS();
//
//        bfs.printG(1, graph);
//
//        System.out.println("--- DFS ---");
//        DFS dfs = new DFS();
//        dfs.printG(1, graph);
//    }
}

//class BFS {
//    Set<GraphNode> visitedNodes = new HashSet<>();
//
//    public void printG(int head, Graph graph) {
//        GraphNode headNode = graph.vertex.get(head);
//        Queue<GraphNode> queueToVisit = new LinkedList<>();
//        queueToVisit.add(headNode);
//        while (!queueToVisit.isEmpty()) {
//            GraphNode currentNode = queueToVisit.poll();
//            if (!visitedNodes.contains(currentNode)) {
//                queueToVisit.addAll(graph.edgeRep.get(currentNode));
//
//                visitedNodes.add(currentNode);
//                System.out.println(currentNode);
//            }
//
//        }
//    }
//}
//
//class DFS {
//    Set<GraphNode> visitedNodes = new HashSet<>();
//
//    public void printG(int head, Graph graph) {
//        GraphNode headNode = graph.vertex.get(head);
//        Stack<GraphNode> stackToVisit = new Stack<>();
//        stackToVisit.add(headNode);
//        while (!stackToVisit.isEmpty()) {
//            GraphNode currentNode = stackToVisit.pop();
//            if (!visitedNodes.contains(currentNode)) {
//                for (GraphNode eachAdj : graph.edgeRep.get(currentNode)) {
//                    if (!stackToVisit.contains(eachAdj)) {
//                        stackToVisit.add(eachAdj);
//                    }
//                }
//
//                visitedNodes.add(currentNode);
//                System.out.println(currentNode);
//            }
//
//        }
//    }
//}
//
//class Graph {
//    Map<Integer, GraphNode> vertex = new HashMap<>();
//    Map<GraphNode, List<GraphNode>> edgeRep = new HashMap<>();
//
//    public void addConnection(int src, int dest) {
//        if (!vertex.containsKey(src)) {
//            vertex.put(src, new GraphNode(src));
//        }
//        if (!vertex.containsKey(dest)) {
//            vertex.put(dest, new GraphNode(dest));
//        }
//        GraphNode srcGraphNode = vertex.get(src);
//        GraphNode destGraphNode = vertex.get(dest);
//
//        if (!edgeRep.containsKey(srcGraphNode)) {
//            edgeRep.put(srcGraphNode, new ArrayList<>());
//        }
//        if (!edgeRep.containsKey(destGraphNode)) {
//            edgeRep.put(destGraphNode, new ArrayList<>());
//        }
//
//        edgeRep.get(srcGraphNode).add(destGraphNode);
//        edgeRep.get(destGraphNode).add(srcGraphNode);
//    }
//
//    public void printG() {
//        System.out.println("-- Vertex " + vertex);
//        for (GraphNode eachGraphNode : edgeRep.keySet()) {
//            System.out.println("-- GN : " + eachGraphNode + " -- Edges: " + edgeRep.get(eachGraphNode));
//        }
//    }
//}
//
// class GraphNode {
//    int val;
//
//    GraphNode(int val) {
//        this.val = val;
//    }
//
//    @Override
//    public String toString() {
//        return val + "";
//    }
//}
