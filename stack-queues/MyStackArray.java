class MyStackArray {

    private int[] arr;
    private int length;

    public MyStackArray() {
        this.arr = new int[10];
        this.length = 0;
    }

    public int peek() {
        return this.arr[length - 1];
    }

    public void push(int data) {
        if (this.length == this.arr.length) {
            extendArray();
        }

        this.arr[length] = data;
        this.length++;
    }

    private void extendArray() {
        int[] newArray = new int[this.length * 2];
        for (int i = 0; i < this.length; i++) {
            newArray[i] = this.arr[i];
        }
        this.arr = newArray;
    }

    public int pop() {
        if (length == 0) {
            return -1;
        }
        this.arr[length - 1] = -1;
        length--;
        return this.arr[length - 1];
    }
}
