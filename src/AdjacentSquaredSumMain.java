import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacentSquaredSumMain {
    public static void main(String[] args) throws Exception {
        int number = 15;

        AdjacentSquaredSum adjacentSquaredSum = new AdjacentSquaredSum(number);

        adjacentSquaredSum.createGraph();
        System.out.println(adjacentSquaredSum);
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
            return "Node Val: " + this.val + " Adjacent: " + this.adjacentNodes.toString();
        }
    }

    private int maxNumber;
    private Map<Integer, Node> mapOfNumberAndNodes;

    private int maxSquaredRootedNumberPossible;

    private Map<Integer, List<Tuple<Node, Node>>> mapOfSquaredToPairs;

    private void initMapOfNumberAndNodes() {
        this.mapOfNumberAndNodes = new HashMap<>();

        for (int eachNumber = 1; eachNumber <= this.maxNumber; eachNumber++) {
            Node numberNode = new Node(eachNumber);
            this.mapOfNumberAndNodes.put(eachNumber, numberNode);
        }
    }

    private void initMapOfSquaredToPairs() throws Exception {
        int maxSum = this.maxNumber + this.maxNumber - 1;

        this.maxSquaredRootedNumberPossible = (int) Math.floor(Math.sqrt(maxSum));

        if (this.maxSquaredRootedNumberPossible <= 1) {
            throw new Exception("No Kidding Please!!!!! I Cannot Work With Numbers " +
                    "Where maxSquaredRootedNumberPossible Is Not Possible");
        }

        this.mapOfSquaredToPairs = new HashMap<>();

        for (int root = 2; root <= this.maxSquaredRootedNumberPossible; root++) {
            List<Tuple<Node, Node>> listOfPairs;
            listOfPairs = new ArrayList<>();
            this.mapOfSquaredToPairs.put(root * root, listOfPairs);
        }
    }

    private void fillMapOfSquaredToPairs() {

    }

    private void initVariables(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    AdjacentSquaredSum(int maxNumber) throws Exception {
        if (maxNumber < 2) {
            throw new Exception("Hey Hey Hey!! We Cannot Work With Number Lesser Than 2");
        }
        initVariables(maxNumber);
    }

    public void createGraph() throws Exception {
        initMapOfNumberAndNodes();

        initMapOfSquaredToPairs();

        fillMapOfSquaredToPairs();
    }

    @Override
    public String toString() {

        return "maxNumber: " + maxNumber + "\n" +
                "mapOfNumberAndNodes: " + mapOfNumberAndNodes + "\n" +
                "maxSquaredRootedNumberPossible: " + maxSquaredRootedNumberPossible + "\n" +
                "mapOfSquaredToPairs: " + mapOfSquaredToPairs + "\n";
    }
}
