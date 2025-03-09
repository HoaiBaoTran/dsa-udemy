class Solution {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);

        // traverse(tree.getRoot());
        System.out.println(tree.lookup(90));
    }

    public static void traverse(Node node) {
        if (node != null) {
            System.out.println(node.getData());
            traverse(node.getLeft());
            traverse(node.getRight());
        }
    }
}