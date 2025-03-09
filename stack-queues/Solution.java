public class Solution {
    public static void main(String[] args) {
        // MyStack myStack = new MyStack();
        // myStack.push(1);
        // myStack.push(2);

        // System.out.println(myStack.peek());

        MyStackArray myStack = new MyStackArray();
        myStack.push(1);
        myStack.push(2);
        myStack.pop();
        System.out.println(myStack.peek());
    }
}