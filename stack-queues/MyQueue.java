class MyQueue {
    private Node first;
    private Node last;
    private int length;

    public MyQueue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public int peek() {
        if (this.length == 0) {
            return -1;
        }
        return this.first.getData();
    }

    public void enqueue(int data) {
        Node node = new Node(data);
        if (this.length == 0) {
            this.first = node;
            this.last = node;
        } else {
            this.last.setNext(node);
            this.last = node;
        }
        this.length++;
    }

    public int dequeue() {
        if (this.length == 0) {
            return -1;
        }

        if (this.first == this.last) {
            this.last = null;
        }
        Node node = this.first;
        this.first = node.getNext();
        return node.getData();
    }
}
