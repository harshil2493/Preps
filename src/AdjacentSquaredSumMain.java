
import java.util.*;

public class AdjacentSquaredSumMain {
    public static void main(String[] args) {
        int offset = 60;
        int number = 0 * offset;

        for (int indexN = number; indexN < number + offset; indexN++) {
            String out = "Working For #: " + indexN;
            long startTime = System.nanoTime();
            AdjacentSquaredSum adjacentSquaredSum = new AdjacentSquaredSum(indexN);

            adjacentSquaredSum.createGraph();
            Tuple<Boolean, String> tupleOfResultSuccessAndGraph = adjacentSquaredSum.visitGraph();

            out += " | " + "Success: " + tupleOfResultSuccessAndGraph.x + " Graph: " + tupleOfResultSuccessAndGraph.y;
            long endTime = System.nanoTime();

            out += " | " + "Time: " + (endTime - startTime) / 1000000.0 + " ms";

            System.out.println(out);
        }
    }
}

class AdjacentSquaredSum {
    boolean extraPrints = false;

    private class Node {
        int val;
        List<Node> adjacentNodes;

        Node(int val) {
            this.val = val;
            this.adjacentNodes = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder adjNodes = new StringBuilder();

            for (Node eachAdjNodes : adjacentNodes) {
                adjNodes.append(" ").append(eachAdjNodes.val);
            }

            return "[Val: " + this.val + " Adjacent: " + adjNodes + "]";
        }
    }

    private int maxNumber;
    private Map<Integer, Node> mapOfNumberAndNodes;

    private int maxSquaredRootedNumberPossible;

    private Set<Integer> setOfSquaredNumbers;

    private void initMapOfNumberAndNodes() {
        this.mapOfNumberAndNodes = new HashMap<>();

        for (int eachNumber = 1; eachNumber <= this.maxNumber; eachNumber++) {
            Node numberNode = new Node(eachNumber);
            this.mapOfNumberAndNodes.put(eachNumber, numberNode);
        }
    }

    private void initMapOfSquaredToPairs() {
        int maxSum = this.maxNumber + this.maxNumber - 1;

        this.maxSquaredRootedNumberPossible = Math.abs((int) Math.floor(Math.sqrt(maxSum)));

        if (this.maxSquaredRootedNumberPossible == 1) {
            if (extraPrints) System.err.println("No Kidding Please!!!!! I Cannot Work With Numbers " +
                    "Where maxSquaredRootedNumberPossible Is Not Possible");
        }

        this.setOfSquaredNumbers = new HashSet<>();

        for (int root = 2; root <= this.maxSquaredRootedNumberPossible; root++) {
            this.setOfSquaredNumbers.add(root * root);
        }
    }

    private void fillMapOfSquaredToPairs() {
        for (Integer eachSquaredKey : this.setOfSquaredNumbers) {
            for (int possibleNode = (eachSquaredKey / 2) + 1; possibleNode <= this.maxNumber; possibleNode++) {
                int alterNateVal = eachSquaredKey - possibleNode;

                if (possibleNode * alterNateVal > 0) {
                    Node xNode = this.mapOfNumberAndNodes.get(possibleNode);
                    Node yNode = this.mapOfNumberAndNodes.get(alterNateVal);

                    xNode.adjacentNodes.add(yNode);

                    yNode.adjacentNodes.add(xNode);
                } else {
                    break;
                }
            }
        }
    }

    private void initVariables(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    AdjacentSquaredSum(int maxNumber) {
        if (maxNumber < 2) {
            if (extraPrints) System.err.println("Hey Hey Hey!! We Cannot Work With Number Lesser Than 2");
        }
        initVariables(maxNumber);
    }

    public void createGraph() {
        initMapOfNumberAndNodes();

        initMapOfSquaredToPairs();

        fillMapOfSquaredToPairs();
    }

    private boolean verifyCompleteness(Set<Node> setOfVisitedNodes) {
        return this.maxNumber == setOfVisitedNodes.size();
    }

    private boolean visit(Node root, Set<Node> setOfVisitedNodes, Stack<Node> stackOfVisit) {
        boolean graphIsComplete = false;
        if (!setOfVisitedNodes.contains(root)) {

            if (!graphIsComplete) {
                stackOfVisit.push(root);
                setOfVisitedNodes.add(root);
                graphIsComplete = verifyCompleteness(setOfVisitedNodes);
            }

            if (!graphIsComplete) {
                for (Node eachNode : root.adjacentNodes) {
                    graphIsComplete = visit(eachNode, setOfVisitedNodes, stackOfVisit);
                    if (graphIsComplete) {
                        break;
                    }
                }
            }

            if (!graphIsComplete) {
                setOfVisitedNodes.remove(root);
                stackOfVisit.pop();
            }
        }

        return graphIsComplete;
    }

    private Tuple<Boolean, String> generateSuccessAndTraversalString(Node root) {
        Set<Node> setOfVisitedNodes = new HashSet<>();
        Stack<Node> stackOfVisit = new Stack<>();
        boolean graphIsComplete = visit(root, setOfVisitedNodes, stackOfVisit);

        StringBuilder traversalString = new StringBuilder();

        if (graphIsComplete) {
            while (!stackOfVisit.isEmpty()) {
                traversalString.append(stackOfVisit.pop().val).append(" ");
            }
        }
        return new Tuple<>(graphIsComplete, traversalString.toString());
    }

    public Tuple<Boolean, String> visitGraph() {
        Node head = null;
        boolean island = false;
        List<Node> islandNodes = new ArrayList<>();
        for (Node eachNode : this.mapOfNumberAndNodes.values()) {
            if (eachNode.adjacentNodes.size() == 1) {
                head = eachNode;
            }
            if (eachNode.adjacentNodes.size() == 0) {
                island = true;
                islandNodes.add(eachNode);
            }
        }
        if (island) {
            if (extraPrints)
                System.out.println("Some Nodes Does Not Have Adjacent Value! Cannot Create Inclusive Graph");
            if (extraPrints)
                System.out.println("-- Island Nodes: " + islandNodes + " --");
        } else {
            if (head == null) {
                if (extraPrints)
                    System.out.println("Head Is Null!! For Number: " + this.maxNumber);

                for (int nodeVal = this.maxNumber; nodeVal > 0; nodeVal--) {
                    if (extraPrints)
                        System.out.println("Exploring With: " + nodeVal);

                    Tuple<Boolean, String> result = generateSuccessAndTraversalString(this.mapOfNumberAndNodes.get(nodeVal));

                    if (result.x) {
                        return result;
                    }
                }
            } else {
                if (extraPrints)
                    System.out.println("Exploring With: " + head);

                Tuple<Boolean, String> result = generateSuccessAndTraversalString(head);

                return result;
            }
        }

        return new Tuple<>(false, "");
    }

    @Override
    public String toString() {

        return "maxNumber: " + maxNumber + "\n" +
                "mapOfNumberAndNodes: " + mapOfNumberAndNodes + "\n" +
                "maxSquaredRootedNumberPossible: " + maxSquaredRootedNumberPossible + "\n" +
                "setOfSquaredNumbers: " + setOfSquaredNumbers + "\n";
    }
}
