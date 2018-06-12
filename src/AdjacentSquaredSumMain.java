
import java.util.*;

public class AdjacentSquaredSumMain {
    public static void main(String[] args) {
        int number = 15;

        AdjacentSquaredSum adjacentSquaredSum = new AdjacentSquaredSum(number);

        adjacentSquaredSum.createGraph();
        adjacentSquaredSum.visitGraph();
    }
}

class AdjacentSquaredSum {
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
            System.err.println("No Kidding Please!!!!! I Cannot Work With Numbers " +
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
            System.err.println("Hey Hey Hey!! We Cannot Work With Number Lesser Than 2");
        }
        initVariables(maxNumber);
    }

    public void createGraph() {
        initMapOfNumberAndNodes();

        initMapOfSquaredToPairs();

        fillMapOfSquaredToPairs();
    }

    private Tuple<Boolean, String> exploreFromGivenHead(Node root) {

        return new Tuple<>(true, "");
    }

    public void visitGraph() {
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
            System.out.println("Some Nodes Does Not Have Adjacent Value! Cannot Create Inclusive Graph");
            System.out.println("-- Island Nodes: " + islandNodes + " --");
        } else {
            if (head == null) {
                System.out.println("Head Is Null!! For Number: " + this.maxNumber);
                for (int nodeVal = this.maxNumber; nodeVal > 0; nodeVal--) {
                    System.out.println("Exploring With: " + nodeVal);

                    Tuple<Boolean, String> result = exploreFromGivenHead(this.mapOfNumberAndNodes.get(nodeVal));

                    if (result.x) {
                        System.out.println(result.y);
                        break;
                    } else {
                        System.out.println("Bad Luck For Number: " + nodeVal);
                    }
                }
            } else {
                System.out.println("Exploring With: " + head);

                Tuple<Boolean, String> result = exploreFromGivenHead(head);
                if (result.x) {
                    System.out.println("Graph: " + result.y);
                }
            }


        }
    }

    @Override
    public String toString() {

        return "maxNumber: " + maxNumber + "\n" +
                "mapOfNumberAndNodes: " + mapOfNumberAndNodes + "\n" +
                "maxSquaredRootedNumberPossible: " + maxSquaredRootedNumberPossible + "\n" +
                "setOfSquaredNumbers: " + setOfSquaredNumbers + "\n";
    }
}
