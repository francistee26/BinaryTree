public class BinaryTree {
    private class BNode {
        private int value;
        private BNode leftChild, rightChild;

        private BNode(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public String toString() {
            return "Node= " + value;
        }

    }

    private BNode root;

    // public BinaryTree(int value) {
    // this.root = new BNode(value);
    // }

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        var node = new BNode(value);
        if (root == null) {
            root = node;
            return;
        }
        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    return;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    return;
                }
                current = current.rightChild;
            }
        }

    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;

            else if (value > current.value)
                current = current.rightChild;

            else
                return true;
        }
        return false;
    }

    public int factorial(int value) {
        if (value < 0)
            throw new IllegalStateException("Negative values are not permited");
        return (value == 0) ? 1 : (value * factorial(value - 1));
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(BNode root) {
        if (root == null)
            return;
        System.out.print(root.value + " ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);

    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(BNode root) {
        if (root == null)
            return;
        traverseInOrder(root.leftChild);
        System.out.print(root.value + " ");
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(BNode root) {
        if (root == null)
            return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.print(root.value + " ");
    }
    public int height(){
        return height(root);
    }

    private int height(BNode root){
        if(root == null)
            return -1;
        if(root.leftChild == null && root.rightChild == null)
            return 0;
        return 1 + Math.max(
                height(root.leftChild), 
                height(root.rightChild));

    }

}