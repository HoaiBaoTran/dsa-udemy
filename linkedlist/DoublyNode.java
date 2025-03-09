class DoublyNode {
    private int data;
    private DoublyNode prev;
    private DoublyNode next;

    public DoublyNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }

    public void setNext(DoublyNode node) {
        this.next = node;
    }

    public void setPrev(DoublyNode node) {
        this.prev = node;
    }

    public DoublyNode getNext() {
        return this.next;
    }

    public DoublyNode getPrev() {
        return this.prev;
    }

    @Override
    public String toString() {
        return this.getPrev() + "<--" + this.getData();
    }

    public String printNext() {
        if (this.getNext() != null) {
            return this.getData() + "-->" + this.getNext().printNext();
        }
        return this.getData() + "-->null";
    }
}
