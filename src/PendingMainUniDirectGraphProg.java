import java.util.*;

public class PendingMainUniDirectGraphProg {
//    public static void main(String[] args) {
//        UniDirectGraph graph = new UniDirectGraph();
//        graph.addConnection(1, 2);
//        graph.addConnection(1, 3);
//        graph.addConnection(1, 7);
//        graph.addConnection(3, 5);
//        graph.addConnection(3, 4);
//        graph.addConnection(5, 6);
//        graph.addConnection(4, 6);
//        graph.addConnection(6, 7);
//        graph.addConnection(7, 2);
//        graph.addConnection(7, 8);
//        graph.addConnection(8, 2);
//        graph.addConnection(9, 6);
//
//        graph.printG();
//
//        TopologicalSort topologicalSort = new TopologicalSort();
//
//        Stack<UniDirectGraphNode> order = topologicalSort.generateTopologicalOrder(graph);
//        System.out.println("order");
//        while (!order.isEmpty()) {
//            System.out.println(order.pop());
//        }
//    }

}

//class TopologicalSort {
//    private boolean checkGraphNodeIsReady(UniDirectGraphNode currentNode,
//                                          UniDirectGraph graph,
//                                          Set<UniDirectGraphNode> setOfVisited) {
//        boolean childsAreVisited = true;
//
//        for (UniDirectGraphNode eachChildNode : graph.edgeRep.get(currentNode)) {
//            if (!setOfVisited.contains(eachChildNode)) {
//                childsAreVisited = false;
//                break;
//            }
//        }
//        return childsAreVisited;
//    }
//
//    private void fillUpStack(UniDirectGraphNode currentNode,
//                             UniDirectGraph graph,
//                             Stack<UniDirectGraphNode> stack,
//                             Set<UniDirectGraphNode> setOfVisited) {
//        if (!setOfVisited.contains(currentNode)) {
//            if (!checkGraphNodeIsReady(currentNode, graph, setOfVisited)) {
//                for (UniDirectGraphNode eachChildNode : graph.edgeRep.get(currentNode)) {
//                    fillUpStack(eachChildNode, graph, stack, setOfVisited);
//                }
//            }
//            setOfVisited.add(currentNode);
//            stack.push(currentNode);
//        }
//    }
//
//    public Stack<UniDirectGraphNode> generateTopologicalOrder(UniDirectGraph graph) {
//        Stack<UniDirectGraphNode> order = new Stack<>();
//        Set<UniDirectGraphNode> setOfVisited = new HashSet<>();
//
//        for (UniDirectGraphNode eachUniDirectGraphNode : graph.vertex.values()) {
//            if (!setOfVisited.contains(eachUniDirectGraphNode)) {
//                fillUpStack(eachUniDirectGraphNode, graph, order, setOfVisited);
//                System.out.println("Stack After : " + eachUniDirectGraphNode + " " + order);
//            }
//        }
//
//        return order;
//    }
//}
//
//class UniDirectGraph {
//    Map<Integer, UniDirectGraphNode> vertex = new HashMap<>();
//    Map<UniDirectGraphNode, List<UniDirectGraphNode>> edgeRep = new HashMap<>();
//
//    public void addConnection(int src, int dest) {
//        if (!vertex.containsKey(src)) {
//            vertex.put(src, new UniDirectGraphNode(src));
//        }
//        if (!vertex.containsKey(dest)) {
//            vertex.put(dest, new UniDirectGraphNode(dest));
//        }
//        UniDirectGraphNode srcGraphNode = vertex.get(src);
//        UniDirectGraphNode destGraphNode = vertex.get(dest);
//
//        if (!edgeRep.containsKey(srcGraphNode)) {
//            edgeRep.put(srcGraphNode, new ArrayList<>());
//        }
//        if (!edgeRep.containsKey(destGraphNode)) {
//            edgeRep.put(destGraphNode, new ArrayList<>());
//        }
//
//        edgeRep.get(srcGraphNode).add(destGraphNode);
//    }
//
//    public void printG() {
//        System.out.println("-- Vertex " + vertex);
//        for (UniDirectGraphNode eachGraphNode : edgeRep.keySet()) {
//            System.out.println("-- GN : " + eachGraphNode + " -- Edges: " + edgeRep.get(eachGraphNode));
//        }
//    }
//}
//
//class UniDirectGraphNode {
//    int val;
//
//    UniDirectGraphNode(int val) {
//        this.val = val;
//    }
//
//    @Override
//    public String toString() {
//        return val + "";
//    }
//}
