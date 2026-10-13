/**
 * Stack (LIFO) implemented with an array.
 * Owner: Risny (Member 2)
 */
public class MyStack {
    private final int[] data;
    private int top;

    public MyStack(int capacity) {
        data = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull() { return top == data.length - 1; }

    /** Push: add to the top. O(1) */
    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow! Stack is full.");
            return false;
        }
        data[++top] = value;
        System.out.println(value + " pushed onto the stack.");
        return true;
    }

    /** Pop: remove from the top. Returns null if empty. O(1) */
    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop from an empty stack.");
            return null;
        }
        return data[top--];
    }

    /** Peek: view the top element without removing it. O(1) */
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek.");
            return null;
        }
        return data[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack (top -> bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("  | " + data[i] + " |" + (i == top ? "  <- top" : ""));
        }
    }
}
