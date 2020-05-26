public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(7);
        bt.insert(4);
        bt.insert(9);
        bt.insert(1);
        bt.insert(6);
        bt.insert(8);
        bt.insert(10);
        System.out.println(bt.height());
        System.out.print("Pre Order Traversal: ");
        bt.traversePreOrder();
        System.out.println();
        System.out.print("In Order Traversal: ");
        bt.traverseInOrder();
        System.out.println();
        System.out.print("Post Order Traversal: ");
        bt.traversePostOrder();

    }
}