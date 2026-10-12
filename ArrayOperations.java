import java.util.Arrays;
import java.util.Random;

/**
 * Array component: fixed-capacity array with insert, delete, search, display.
 * Owner: Fathima (Member 1 & 5)
 */
public class ArrayOperations {
    private final int[] data;
    private int size;

    public ArrayOperations(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == data.length; }
    public int getSize() { return size; }

    /** Insert value at index (0..size). Shifts elements to the right. O(n) */
    public boolean insert(int index, int value) {
        if (isFull()) {
            System.out.println("Array is full! Cannot insert.");
            return false;
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid index! Allowed range: 0 to " + size);
            return false;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        System.out.println(value + " inserted at index " + index);
        return true;
    }

    /** Insert at the end. O(1) */
    public boolean insertAtEnd(int value) {
        return insert(size, value);
    }

    /** Delete element at index. Shifts elements to the left. O(n) */
    public boolean delete(int index) {
        if (isEmpty()) {
            System.out.println("Array is empty! Nothing to delete.");
            return false;
        }
        if (index < 0 || index >= size) {
            System.out.println("Invalid index! Allowed range: 0 to " + (size - 1));
            return false;
        }
        int removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        System.out.println(removed + " deleted from index " + index);
        return true;
    }

    /** Linear search. Returns index or -1. O(n) */
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array [" + size + " elements]: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + (i < size - 1 ? ", " : ""));
        }
        System.out.println();
    }

    /** Returns a copy containing only the filled part of the array. */
    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    /** Clears the array and fills it with random numbers (for testing searches). */
    public void fillRandom(int count, int maxValue) {
        if (count > data.length) {
            count = data.length;
        }
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            data[i] = random.nextInt(maxValue) + 1;
        }
        size = count;
        System.out.println(count + " random numbers (1-" + maxValue + ") generated.");
    }
}
