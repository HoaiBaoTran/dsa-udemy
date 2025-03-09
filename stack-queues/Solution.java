public class Solution {
    public static void main(String[] args) {
        // MyStack myStack = new MyStack();
        // myStack.push(1);
        // myStack.push(2);

        // System.out.println(myStack.peek());

        // MyStackArray myStack = new MyStackArray();
        // myStack.push(1);
        // myStack.push(2);
        // myStack.pop();
        // System.out.println(myStack.peek());

        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        System.out.println(myQueue.peek());
        myQueue.dequeue();
        System.out.println(myQueue.peek());
    }
}