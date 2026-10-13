/**
 * Singly Linked List with insert, delete, search, display.
 * Owner: Nameek (Member 3)
 */
public class MyLinkedList {

    /** A single node: data + pointer to next node. */
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;
    private int lastSearchSteps;

    public boolean isEmpty() { return head == null; }
    public int getSize() { return size; }
    public int getLastSearchSteps() { return lastSearchSteps; }

    /** Insert at the beginning. O(1) */
    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
        System.out.println(value + " inserted at the beginning.");
    }

    /** Insert at the end. O(n) */
    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
        System.out.println(value + " inserted at the end.");
    }

    /** Delete the first node containing value. O(n) */
    public boolean delete(int value) {
        if (isEmpty()) {
            System.out.println("List is empty! Nothing to delete.");
            return false;
        }
        if (head.data == value) {
            head = head.next;
            size--;
            System.out.println(value + " deleted.");
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println(value + " not found in the list.");
            return false;
        }
        current.next = current.next.next;
        size--;
        System.out.println(value + " deleted.");
        return true;
    }

    /** Search by value. Returns position (0-based) or -1. O(n) */
    public int search(int value) {
        lastSearchSteps = 0;
        Node current = head;
        int position = 0;
        while (current != null) {
            lastSearchSteps++;
            if (current.data == value) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Linked List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
