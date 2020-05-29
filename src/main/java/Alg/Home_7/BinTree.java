package Alg.Home_7;

//Task-One

import java.util.LinkedList;
import java.util.Queue;

public class BinTree {
    private Node root;
    public BinTree() {
        this.root = null;
    }

    private Node addNode(Node currentNode, int data) {
        if (currentNode == null) {
            return new Node(data);
        }
        if (data < currentNode.data) {
            currentNode.left = addNode(currentNode.left, data);
        }
        else if (currentNode.data < data) {
            currentNode.right = addNode(currentNode.right, data);
        }
        return currentNode;
    }

    private Node deleteNode(Node currentNode, int data) {
        if (currentNode == null) {
            return null;
        }
        if (data == currentNode.data) {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            }
            if (currentNode.right == null) {
                return currentNode.left;
            }
            if (currentNode.left == null) {
                return currentNode.right;
            }
            int smallestData = smallestData(currentNode.right);
            currentNode.data = smallestData;
            currentNode.right = deleteNode(currentNode.right, smallestData);
            return currentNode;
        }

        if (data < currentNode.data) {
            currentNode.left = deleteNode(currentNode.left, data);
            return currentNode;
        }

        currentNode.right = deleteNode(currentNode.right, data);
        return currentNode;
    }

    private int smallestData(Node root) {
        return root.left == null ? root.data : smallestData(root.left);
    }

    public void add(int data) {
        root = addNode(root, data);
    }

    public void delete(int data) {
        root = deleteNode(root, data);
    }

    public void dFS(Node node) {
        if (node != null) {
            dFS(node.left);
            System.out.print(node.data + " ");
            dFS(node.right);
        }
    }


    public void bFS() {
        if (!(root == null)) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right!= null) {
                    queue.add(node.right);
                }
            }
        }
    }

    private class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("It compiles senpai!");
        System.out.println("##############################\n");
        int[] arr = {7, 12, 33, 14, 17, 88, 104, 376, 3, 1, 40, 5};
        BinTree bin = new BinTree();
        for (int i = 0; i < arr.length; i++) {
            bin.add(arr[i]);
        }

        bin.bFS();
        //7 3 12 1 5 33 14 88 17 40 104 376
        System.out.println();
        bin.dFS(bin.root);
        //1 3 5 7 12 14 17 33 40 88 104 376
        System.out.println("\n##############################");
        System.out.println("##############################\n");
        bin.delete(33);
        bin.bFS();
        //7 3 12 1 5 40 14 88 17 104 376
        System.out.println();
        bin.dFS(bin.root);
        //1 3 5 7 12 14 17 40 88 104 376
    }
}
