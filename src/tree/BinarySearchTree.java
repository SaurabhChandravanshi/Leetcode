package tree;

/*
Paul has a set of unique numbers. He wants to store numbers in a binary tree such that
whenever a number is given, he can exactly tell how many numbers are less than the given
number.
Help Paul by coding the logic in your language of choice without using any libraries for tree
implementation.
 */
public class BinarySearchTree {

    static Node root = null;
    static class Node {
        int val;
        Node left;
        Node right;
        public Node() {}
        public Node(int val) {
            this.val = val;
        }
    }

    public void insert(int val) {
        root = insertBST(root, val);
    }
    public Node insertBST(Node root, int val) {
        if(root == null) {
            root = new Node(val);
        }
        else if(val < root.val) {
            root.left = insertBST(root.left, val);
        }
        else if(val > root.val) {
            root.right = insertBST(root.right, val);
        }
        return root;
    }

    public void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public int lessThanNumbers(Node root, int key) {
        if(root == null) return 0;
        if(key > root.val) {
            return 1 + lessThanNumbers(root.left, key) + lessThanNumbers(root.right, key);
        }
        return lessThanNumbers(root.left, key);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(8);
        bst.insert(6);
        bst.insert(7);
        bst.insert(16);

        System.out.print("Inorder BST: ");
        bst.inorder(root);
        System.out.println();

        System.out.println("Less than 9: "+bst.lessThanNumbers(root, 9));
        System.out.println("Less than 16: "+bst.lessThanNumbers(root, 16));
        System.out.println("Less than 5: "+bst.lessThanNumbers(root, 5));
    }
}
