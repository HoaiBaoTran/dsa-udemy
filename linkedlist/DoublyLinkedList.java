class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int length;

    public DoublyLinkedList(int data) {
        this.head = new DoublyNode(data);
        this.tail = head;
        this.length = 1;
    }

    public void append(int data) {
        DoublyNode node = new DoublyNode(data);
        node.setPrev(this.tail);
        this.tail.setNext(node);
        this.tail = node;
        this.length++;
    }

    public void prepend(int data) {
        DoublyNode node = new DoublyNode(data);
        node.setNext(this.head);
        this.head.setPrev(node);
        this.head = node;
        this.length++;
    }

    public void insert(int index, int data) {
        DoublyNode node = new DoublyNode(data);
        DoublyNode currentNode = traverseToIndex(index - 1);
        node.setNext(currentNode.getNext());
        currentNode.getNext().setPrev(node);
        currentNode.setNext(node);
        node.setPrev(currentNode);
        this.length++;
    }

    public void remove(int index) {
        DoublyNode prevNode = traverseToIndex(index - 1);
        DoublyNode nextNode = prevNode.getNext().getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        this.length--;

    }

    private DoublyNode traverseToIndex(int index) {
        DoublyNode currentHead = this.head;
        int i = 0;
        while (i < index) {
            currentHead = currentHead.getNext();
            i++;
        }

        return currentHead;
    }

    public String printNext() {
        return this.head.printNext();
    }

    @Override
    public String toString() {
        return this.tail + "";
    }
}
