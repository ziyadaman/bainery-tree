package Project;

public class Binarysearchtree {

    class Node {
        int data;
        Node left, right;

        public Node(int key) {
            data = key;
            left = right = null;
        }
    }

    Node root;

    // Method to insert a value into the BST
    void insert(int x) {
        this.root = insertUtil(this.root, x);
    }

    Node insertUtil(Node root, int x) {
        if (root == null) {
            return new Node(x);
        }
        if (root.data < x) {
            root.right = insertUtil(root.right, x);
        } else if (root.data > x) {
            root.left = insertUtil(root.left, x);
        }
        return root;
    }

    // Method to search a value in the BST
    boolean search(int x) {
        return searchUtil(this.root, x);
    }

    boolean searchUtil(Node root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }
        if (root.data < x) {
            return searchUtil(root.right, x);
        } else {
            return searchUtil(root.left, x);
        }
    }

    // Method to delete a value from the BST
    void deleteNode(int x) {
        this.root = deleteNodeUtil(this.root, x);
    }

    Node deleteNodeUtil(Node root, int x) {
        if (root == null) {
            return root;
        }
        if (root.data < x) {
            root.right = deleteNodeUtil(root.right, x);
        } else if (root.data > x) {
            root.left = deleteNodeUtil(root.left, x);
        } else {
            // Node to be deleted found
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteNodeUtil(root.right, root.data);
        }
        return root;
    }

    int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Method for inorder traversal
    void inorder() {
        inorderUtil(this.root);
    }

    void inorderUtil(Node root) {
        if (root != null) {
            inorderUtil(root.left);
            System.out.print(root.data + " ");
            inorderUtil(root.right);
        }
    }

    public static void main(String[] args) {
        Binarysearchtree bst = new Binarysearchtree();

        System.out.println("After insertion: ");
        bst.insert(10);
        bst.insert(20);
        bst.insert(50);
        bst.insert(80);
        bst.insert(70);
        bst.insert(60);
        bst.inorder();

        System.out.println("\n\nSearch if 90 exists: ");
        if (bst.search(90)) {
            System.out.println("Yep!");
        } else {
            System.out.println("Nope!");
        }

        System.out.println("\nSearch if 70 exists: ");
        if (bst.search(70)) {
            System.out.println("Yep!");
        } else {
            System.out.println("Nope!");
        }

        System.out.println("\nBST before deleting 20: ");
        bst.inorder();
        System.out.println();
        bst.deleteNode(20);

        System.out.println("\nSearch if 20 exists after deletion: ");
        if (bst.search(20)) {
            System.out.println("Yep!");
        } else {
            System.out.println("Nope!");
        }

        System.out.println("\nBST after deletion: ");
        bst.inorder();
    }
}