package Alg.Home_7;

public class AVLTree {

    Node basis;

    private int height(Node N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }


    private int max(int a, int b) {
        return Math.max(a, b);
    }


    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }


    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;


        y.left = x;
        x.right = T2;


        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private int getBalance(Node N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }

    public Node insert(Node node, int key) {

        if (node == null) {
            return (new Node(key));
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        }
        else if (key > node.key) {
            node.right = insert(node.right, key);
        }
        else {
            return node;
        }

        node.height = 1 + max(height(node.left), height(node.right));


        int balance = getBalance(node);


        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void show(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            show(node.left);
            show(node.right);
        }
    }


    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }




    Node deleteNode(Node basic, int key) {
        if (basic == null) {
            return basic;
        }


        if (key < basic.key) {
            basic.left = deleteNode(basic.left, key);
        }


        else if (key > basic.key) {
            basic.right = deleteNode(basic.right, key);
        }


        else {
            if ((basic.left == null) || (basic.right == null)) {
                Node temp = null;
                if (temp == basic.left)
                    temp = basic.right;
                else
                    temp = basic.left;
                if (temp == null) {
                    temp = basic;
                    basic = null;
                }
                else
                    basic = temp;

            }
            else {
                Node temp = minValueNode(basic.right);
                basic.key = temp.key;
                basic.right = deleteNode(basic.right, temp.key);
            }
        }


        if (basic == null) {
            return basic;
        }

        basic.height = max(height(basic.left), height(basic.right)) + 1;
        int balance = getBalance(basic);

        if (balance > 1 && getBalance(basic.left) >= 0)
            return rightRotate(basic);

        if (balance > 1 && getBalance(basic.left) < 0) {
            basic.left = leftRotate(basic.left);
            return rightRotate(basic);
        }

        if (balance < -1 && getBalance(basic.right) <= 0)
            return leftRotate(basic);

        if (balance < -1 && getBalance(basic.right) > 0) {
            basic.right = rightRotate(basic.right);
            return leftRotate(basic);
        }
        return basic;
    }
    private class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.basis = tree.insert(tree.basis, 10);
        tree.basis = tree.insert(tree.basis, 20);
        tree.basis = tree.insert(tree.basis, 30);
        tree.basis = tree.insert(tree.basis, 40);
        tree.basis = tree.insert(tree.basis, 50);
        tree.basis = tree.insert(tree.basis, 25);

        tree.show(tree.basis);
    }
}