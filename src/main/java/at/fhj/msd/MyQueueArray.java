package at.fhj.msd;

 // Generic implementation of a circular queue using an array
public class MyQueueArray<E> {
    private E[] data; // Array to store queue elements
    private int front; // Index of the front element
    private int rear; // Index where the next element will be inserted
 
     // Constructor to initialize the queue
    @SuppressWarnings("unchecked")
    public MyQueueArray() {
        data = (E[]) new Object[11]; // One extra slot to distinguish full from empty
        front = 0;
        rear = 0;
    }
 
    // Calculates the number of elements using modulo math
    public int size() {
        return (rear - front + data.length) % data.length;
    }
 
    // Checks if the queue is empty
    public boolean isEmpty() {
        return front == rear;
    }
 
    // Checks if the queue is full
    private boolean isFull() {
        return (rear + 1) % data.length == front;
    }
 
    // Adds element at the end of the queue
    public void put(E element) {
        if (isFull()) {
            resize(); // Resize the array if it's full
        }
        data[rear] = element; // Insert the element

        rear = (rear + 1) % data.length; // Move rear forward in a circular way
    }
 
    // Removes and returns the first element
    public E get() {
        if (isEmpty()) {
            return null; // Return null if queue is empty
        }
        E value = data[front]; // Get the front element
        data[front] = null; // Help garbage collector
        front = (front + 1) % data.length; // Move front forward in a circular way
        return value;
    }
 
    // Resizes the circular array
    @SuppressWarnings("unchecked")
    private void resize() {
        int oldSize = data.length;
        int currentSize = size(); // Number of actual elements in queue
        E[] newData = (E[]) new Object[oldSize * 2]; // Create a new array with double the size
 
        // Copy elements from old array to new array in correct order
        for (int i = 0; i < currentSize; i++) {
            newData[i] = data[(front + i) % oldSize];
        }
 
        data = newData; // Replace old array with new one
        front = 0; // Reset front
        rear = currentSize; // Set rear to the end of the copied elements
    }
}