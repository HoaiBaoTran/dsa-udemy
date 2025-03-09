class MyStack {
    private Node top;
    private Node bottom;
    private int length;

    public MyStack() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    public int peek() {
        return top.getData();
    }

    public void push(int data) {
        Node node = new Node(data);
        if (this.length == 0) {
            this.top = node;
            this.bottom = node;
        } else {
            node.setNext(this.top);
            this.top = node;
        }
        this.length++;
    }

    public int pop() {
        if (this.length == 0) {
            return -1;
        }
        if (this.top == this.bottom) {
            this.bottom = null;
        }

        Node currentHead = this.top;
        this.top = currentHead.getNext();
        this.length--;
        return currentHead.getData();
    }
}
