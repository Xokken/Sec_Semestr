package Alg.Home_7;

public class AVLTree {
    private Node root;
    public AVLTree() {}

    public void add(int data) {
        root = addNode(root, data);
    }

    public void delete(int data) {
        root = deleteNode(root, data);
    }


    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node two = x.right;
        x.right = y;
        y.left = two;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node two = y.left;
        y.left = x;
        x.right = two;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    private int getBalance(Node N) {
        if (N == null) {
            return 0;
        }
        else{
            return height(N.left) - height(N.right);
        }
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    private Node addNode(Node node, int data) {
        if (node == null) {
            return (new Node(data));
        }

        if (data < node.data) {
            node.left = addNode(node.left, data);
        }
        else {
            node.right = addNode(node.right, data);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private Node deleteNode(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = deleteNode(root.left, data);
        }
        else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        }
        else {
            if ((root.left == null) || (root.right == null)) {
                Node buf;
                if (root.left != null) {
                    buf = root.left;
                }
                else {
                    buf = root.right;
                }
                if (buf == null) {
                    buf = root;
                    root = null;
                }
                else {
                    root = buf;
                    buf = null;
                }
            }
            else {
                Node buf = minValueNode(root.right);
                root.data = buf.data;
                root.right = deleteNode(root.right, buf.data);
            }
        }
        if (root == null) {
            return null;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0){
            return rightRotate(root);
        }

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0){
            return leftRotate(root);
        }


        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;

    }

    private class Node {
        private Node left, right;
        private int height = 1;
        private int data;

        private Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        System.out.println("It compiles senpai!");
        System.out.println("##############################\n");

        AVLTree tree = new AVLTree();
        tree.add(30);
        tree.add(6);
        tree.add(7);
        tree.add(12);
        tree.add(4);
        tree.add(5);
        tree.delete(4);
        tree.delete(5);



    }
}