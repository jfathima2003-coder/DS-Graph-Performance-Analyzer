/**
 * Queue (FIFO) implemented as a circular array.
 * Owner: Risny (Member 2)
 */
public class MyQueue {
    private final int[] data;
    private int front;
    private int size;

    public MyQueue(int capacity) {
        data = new int[capacity];
        front = 0;
        size = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == data.length; }

    /** Enqueue: add at the rear. O(1) */
    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot enqueue.");
            return false;
        }
        int rear = (front + size) % data.length;
        data[rear] = value;
        size++;
        System.out.println(value + " enqueued.");
        return true;
    }

    /** Dequeue: remove from the front. Returns null if empty. O(1) */
    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return null;
        }
        int value = data[front];
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    /** Front: view the first element without removing it. O(1) */
    public Integer front() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Nothing at the front.");
            return null;
        }
        return data[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (front -> rear): ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[(front + i) % data.length] + (i < size - 1 ? " <- " : ""));
        }
        System.out.println();
    }
}
