public class BinarySearchTree{

    public Node root;

    BinarySearchTree() {
            root = null;
    }

    public void insert(int value){
        root = insertRec(root, value);
    }

    public Node insertRec(Node root, int value) {
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(value);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (value < root.value)
            root.left = insertRec(root.left, value);
        else if (value > root.value)
            root.right = insertRec(root.right, value);

        /* return the (unchanged) node pointer */
        return root;
    }

    public int search(int value){
        Node result = search(this.root, value);
        return result != null ? result.value : -1;
    }

    // A utility function to search a given value in BST
    public Node search(Node root, int value)
    {
        // Base Cases: root is null or value is present at root
        if (root==null || root.value==value)
            return root;

        // val is greater than root's value
        if (root.value > value)
            return search(root.left, value);

        // val is less than root's value
        return search(root.right, value);
    }


    public void inOrderTraversal(){
        System.out.println("Printing InOrder Traversal");
        this.inOrderTraversal(this.root);
        System.out.println();
    }

    public void preOrderTraversal(){
        System.out.println("Printing PreOrder Traversal");
        this.preOrderTraversal(this.root);
        System.out.println();
    }

    public void postOrderTraversal(){
        System.out.println("Printing postOrderTraversal ");
        this.postOrderTraversal(this.root);
        System.out.println();
    }

    public void preOrderTraversal(Node root){
        if (root == null) {
            return;
        } else {
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void inOrderTraversal(Node root){
        if (root == null) {
            return;
        } else {
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(Node root){
        if (root == null) {
            return;
        } else {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }


}

class Node{
    Node left = null;
    Node right = null;
    int value;

    public Node(int value){
        this.value = value;
    }
}
