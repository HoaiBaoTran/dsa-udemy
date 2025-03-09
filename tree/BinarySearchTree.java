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
}
