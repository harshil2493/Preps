public class PendingMainBTP {
//    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//
//        BinaryTreeNode b73 = binaryTree.addNode(73);
//        BinaryTreeNode b66 = binaryTree.addNode(66);
//        BinaryTreeNode b85 = binaryTree.addNode(85);
//        BinaryTreeNode b35 = binaryTree.addNode(35);
//        BinaryTreeNode b69 = binaryTree.addNode(69);
//        BinaryTreeNode b75 = binaryTree.addNode(75);
//        BinaryTreeNode b100 = binaryTree.addNode(100);
//        BinaryTreeNode b70 = binaryTree.addNode(70);
//        BinaryTreeNode b79 = binaryTree.addNode(79);
//        BinaryTreeNode b89 = binaryTree.addNode(89);
//
//        binaryTree.inorder(binaryTree.head);
//    }
}

//class BinaryTree {
//
//    BinaryTreeNode head = null;
//
//    public void inorder(BinaryTreeNode node) {
//        if (node != null) {
//            inorder(node.left);
//            System.out.println(node);
//            inorder(node.right);
//        }
//    }
//
//    public void preorder(BinaryTreeNode node) {
//        if (node != null) {
//            System.out.println(node);
//            inorder(node.left);
//            inorder(node.right);
//        }
//    }
//
//    public void postorder(BinaryTreeNode node) {
//        if (node != null) {
//            inorder(node.left);
//            inorder(node.right);
//            System.out.println(node);
//        }
//    }
//
//    public BinaryTreeNode addNode(int val) {
//        BinaryTreeNode newNode = new BinaryTreeNode(val);
//        if (head == null) {
//            head = newNode;
//        } else {
//            boolean parentFound = false;
//            BinaryTreeNode parentNode = head;
//
//            while (!parentFound) {
//                if (parentNode.val <= val) {
//                    if (parentNode.right != null) {
//                        parentNode = parentNode.right;
//                    } else {
//                        parentFound = true;
//                    }
//                } else {
//                    if (parentNode.left != null) {
//                        parentNode = parentNode.left;
//                    } else {
//                        parentFound = true;
//                    }
//                }
//            }
//            if (parentNode.val <= val) {
//                System.out.println("adding " + val + " to right to " + parentNode);
//                parentNode.right = newNode;
//            } else {
//                System.out.println("adding " + val + " to left to " + parentNode);
//                parentNode.left = newNode;
//            }
//        }
//
//        return newNode;
//    }
//}


//class BinaryTreeNode {
//    int val;
//    BinaryTreeNode left;
//    BinaryTreeNode right;
//
//    BinaryTreeNode(int val) {
//        this.val = val;
//    }
//
//    BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//
//    @Override
//    public String toString() {
//        return "val: " + val;
//    }
//}
