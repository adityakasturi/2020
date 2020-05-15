public class main {

    public static void main(String args[]){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(10);
        tree.insert(6);
        tree.insert(4);
        tree.insert(7);
        tree.insert(14);
        tree.insert(13);
        tree.insert(18);
        System.out.println(tree.search(4));
        System.out.println(tree.search(15));

        tree.preOrderTraversal();
        tree.inOrderTraversal();
        tree.postOrderTraversal();

    }

}
