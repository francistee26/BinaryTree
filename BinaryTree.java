import java.util.ArrayList;

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
    private int size;

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
            size++;
            return;
        }
        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    size++;
                    return;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    size++;
                    return;
                }
                current = current.rightChild;
            }
        }

    }

    public int size(){
        return size;
    }

    public int countLeaves(){
        return  countLeaves(root);
    }
    private int count;
    private int countLeaves(BNode root){
        if(root == null)
            return 0;
        
        if(isLeaf(root))
            count++;
            
        countLeaves(root.leftChild);
        countLeaves(root.rightChild);
        return count;
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

    public int height() {
        return height(root);
    }

    private int height(BNode root) {
        if (root == null)
            return -1;
        if (isLeaf(root))
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));

    }

    public int minValueInTree() {
        return minValueInTree(root);
    }

    private int minValueInTree(BNode root) {
        if (root == null)
            throw new IllegalStateException("Empty Binary Tree");
        if (isLeaf(root))
            return root.value;
        var left = minValueInTree(root.leftChild);
        var right = minValueInTree(root.rightChild);
        var minOfLeftAndRight = Math.min(left, right);

        return Math.min(minOfLeftAndRight, root.value);
    }

    public int minValueInBinarySearchTree() {
        return minValueInBinarySearchTree(root);
    }

    public int minValueInBinarySearchTree(BNode root) {
        if (root == null)
            throw new IllegalStateException();
        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    private boolean isLeaf(BNode root) {
        return root.leftChild == null && root.rightChild == null;
    }

    public boolean equal(BinaryTree other) {
        if (other == null)
            return false;
        return equals(root, other.root);

    }

    private boolean equals(BNode root1, BNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 != null && root2 != null) {
            return root1.value == root2.value && equals(root1.leftChild, root2.leftChild)
                    && equals(root1.rightChild, root2.rightChild);
        }

        return false;
    }

    public boolean validatingBST() {
        return validatingBST(root);
    }

    private boolean validatingBST(BNode root) {
        if (root == null) {
            return true;
        }
        if (isLeaf(root))
            return true;
        return root.value >= root.leftChild.value && root.value <= root.rightChild.value
                && validatingBST(root.leftChild) && validatingBST(root.rightChild);

    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(BNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.value < min || root.value > max)
            return false;
        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public void swapRoot() {
        swapRoot(root);
    }

    private void swapRoot(BNode root) {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;

    }

    public String getNOdesAtDistance(int k) {
        var list = new ArrayList<Integer>();
        getNOdesAtDistance(root, k, list);
        return list.toString();
    }

    private void getNOdesAtDistance(BNode root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (distance == 0) {
            list.add(root.value);
            return;
        }
        getNOdesAtDistance(root.leftChild, distance - 1, list);
        getNOdesAtDistance(root.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder(){
        for(var i = 0; i<=height(); i++){
            for(var value : getNOdesAtDistance(i).toCharArray())
                System.out.print(value);
            System.out.println();
        }
    }

}