class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    SinglyLinkedList(int data) {
        this.head = new Node(data);
        this.tail = head;
        length = 1;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public int getLength() {
        return this.length;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        Node currentNode = tail;
        currentNode.setNext(newNode);
        tail = newNode;
        length++;
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.setNext(this.head);
        this.head = newNode;
        this.length++;
    }

    public void insert(int index, int data) {
        // check input
        if (index >= this.length) {
            this.append(data);
        }
        Node currentNode = traverseToIndex(index - 1);
        Node newNode = new Node(data);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        length++;
    }

    private Node traverseToIndex(int index) {
        Node currentNode = this.head;
        int i = 0;
        while (i < index) {
            currentNode = currentNode.getNext();
            i++;
        }
        return currentNode;
    }

    public void remove(int index) {
        // check input
        if (index >= this.length) {

        }
        Node currentNode = traverseToIndex(index - 1);
        currentNode.setNext(currentNode.getNext().getNext());
        this.length--;
    }

    public Node reverse() {
        // check input
        if (this.length <= 1) {
            return this.head;
        }

        Node first = this.head;
        Node second = first.getNext();
        this.tail = first;
        while (second != null) {
            Node nextNode = second.getNext();
            second.setNext(first);
            first = second;
            second = nextNode;
        }
        this.head.setNext(null);
        this.head = first;
        return second;
    }

    @Override
    public String toString() {
        return this.getHead() + "";
    }
}