import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinarySearchTree {
    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public void insert(int data) {
        Node node = new Node(data);
        if (this.root == null) {
            this.root = node;
        } else {
            Node currentNode = this.root;
            while (true) {
                if (data < currentNode.getData()) {
                    // Left
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(node);
                        return;
                    }
                    currentNode = currentNode.getLeft();
                } else {
                    // Right
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(node);
                        return;
                    }
                    currentNode = currentNode.getRight();

                }
            }
        }
    }

    public Node lookup(int data) {
        if (this.root == null) {
            return null;
        }

        Node currentNode = this.root;
        while (currentNode != null) {
            if (currentNode.getData() > data) {
                // Left
                currentNode = currentNode.getLeft();
            } else if (currentNode.getData() < data) {
                // Right
                currentNode = currentNode.getRight();
            } else {
                return currentNode;
            }
        }
        return currentNode;
    }

    public boolean remove(int data) {
        if (this.root == null) {
            return false;
        }

        Node currentNode = this.root;
        Node parentNode = null;
        while (currentNode != null) {
            if (data < currentNode.getData()) {
                // Left
                parentNode = currentNode;
                currentNode = currentNode.getLeft();
            } else if (data > currentNode.getData()) {
                // Right
                parentNode = currentNode;
                currentNode = currentNode.getRight();
            } else if (data == currentNode.getData()) {
                // Have a match
                // Option 1: No right child
                if (currentNode.getRight() == null) {
                    if (parentNode == null) {
                        // this is root node case
                        this.root = currentNode.getLeft();
                    } else {
                        // if parent > current value, make current left child a child of parent
                        if (currentNode.getData() < parentNode.getData()) {
                            parentNode.setLeft(currentNode.getLeft());
                        }
                        // if parent < current value, make current right child a child of parent
                        else if (currentNode.getData() > parentNode.getData()) {
                            parentNode.setRight(currentNode.getLeft());
                        }
                    }
                }
                // Option 2 Right child doesn't have left child
                else if (currentNode.getRight().getLeft() == null) {
                    if (parentNode == null) {
                        this.root = currentNode.getLeft();
                    } else {
                        currentNode.getRight().setLeft(currentNode.getLeft());

                        // if parent > current, make right child of the left parent
                        if (currentNode.getData() < parentNode.getData()) {
                            parentNode.setLeft(currentNode.getRight());
                        }

                        // if parent < current, make right child a right child of the parent
                        else if (currentNode.getData() > parentNode.getData()) {
                            parentNode.setRight(currentNode.getRight());
                        }
                    }
                }
                // Option 3 Right child that has a left child
                else {
                    // find the Right child's left most child
                    Node leftMost = currentNode.getRight().getLeft();
                    Node leftMostParent = currentNode.getRight();
                    while (leftMost.getLeft() != null) {
                        leftMostParent = leftMost;
                        leftMost = leftMost.getLeft();
                    }

                    // Parent's left subtree is now leftmost's right subtree
                    leftMostParent.setLeft(leftMost.getRight());
                    leftMost.setLeft(currentNode.getLeft());
                    leftMost.setRight(currentNode.getRight());

                    if (parentNode == null) {
                        this.root = leftMost;
                    } else {
                        if (currentNode.getData() < parentNode.getData()) {
                            parentNode.setLeft(leftMost);
                        } else if (currentNode.getData() > parentNode.getData()) {
                            parentNode.setRight(leftMost);
                        }
                    }
                }
            }
        }
        return true;
    }

    public void breathFirstSearch() {
        Node currentNode = this.root;
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.poll();
            list.add(currentNode.getData());
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }

        for (Integer data : list) {
            System.out.print(data + " ");
        }
    }

    public List<Integer> breathFirstSearchRecursive(Queue<Node> queue, List<Integer> list) {
        // base case
        if (queue.size() == 0) {
            return list;
        }

        Node currentNode = queue.poll();
        list.add(currentNode.getData());
        if (currentNode.getLeft() != null) {
            queue.add(currentNode.getLeft());
        }
        if (currentNode.getRight() != null) {
            queue.add(currentNode.getRight());
        }

        return breathFirstSearchRecursive(queue, list);

    }

    public List<Integer> depthFirstSearchInOrder() {
        return traverseInOder(this.root, new ArrayList<Integer>());
    }

    private List<Integer> traverseInOder(Node node, List<Integer> list) {
        if (node.getLeft() != null) {
            traverseInOder(node.getLeft(), list);
        }
        list.add(node.getData());
        if (node.getRight() != null) {
            traverseInOder(node.getRight(), list);
        }
        return list;
    }

    public List<Integer> depthFirstSearchPreOrder() {
        return traversePreOrder(this.root, new ArrayList<Integer>());
    }

    private List<Integer> traversePreOrder(Node node, List<Integer> list) {
        list.add(node.getData());
        if (node.getLeft() != null) {
            traversePreOrder(node.getLeft(), list);
        }
        if (node.getRight() != null) {
            traversePreOrder(node.getRight(), list);
        }
        return list;
    }

    public List<Integer> depthFirstSearchPostOrder() {
        return traversePostOrder(this.root, new ArrayList<Integer>());

    }

    private List<Integer> traversePostOrder(Node node, List<Integer> list) {
        if (node.getLeft() != null) {
            traversePostOrder(node.getLeft(), list);
        }
        if (node.getRight() != null) {
            traversePostOrder(node.getRight(), list);
        }
        list.add(node.getData());
        return list;
    }

}
