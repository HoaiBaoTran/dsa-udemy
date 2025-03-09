import java.util.Stack;

class QueueUsingStack {
    private Stack<Integer> myStack;
    private Stack<Integer> helperStack;
    private int peek;

    public QueueUsingStack() {
        this.myStack = new Stack<>();
        this.helperStack = new Stack<>();
    }

    public void push(int x) {
        while (!myStack.isEmpty()) {
            helperStack.push(myStack.pop());
        }

        myStack.push(x);

        while (!helperStack.isEmpty()) {
            myStack.push(helperStack.pop());
        }
    }

    public int peek() {
        return myStack.peek();
    }

    public int pop() {
        return myStack.pop();
    }

    public boolean empty() {
        return myStack.isEmpty();
    }
}