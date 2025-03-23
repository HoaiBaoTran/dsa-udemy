import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        tree.breathFirstSearch();
        System.out.println();

        // 9
        // 4 20
        // 1 6 15 170

        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.getRoot());
        List<Integer> list = tree.breathFirstSearchRecursive(
                queue,
                new ArrayList<Integer>());

        for (Integer data : list) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void traverse(Node node) {
        if (node != null) {
            System.out.println(node.getData());
            traverse(node.getLeft());
            traverse(node.getRight());
        }
    }
}