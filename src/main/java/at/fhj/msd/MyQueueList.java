package at.fhj.msd;
 
public class MyQueueList<E> {
    private Node<E> front;  // Points to the front of the queue
    private Node<E> rear; // Points to the rear of the queue
 
    // Inner node class
    private static class Node<E> {
        E data;  // Data stored in the node
        Node<E> next; // Reference to the next node
 
        Node(E data) {
            this.data = data;
        }
    }
 
     /**
     * Constructor initializes an empty queue.
     */
    public MyQueueList() {
        front = null;
        rear = null;
    }
 
   /**
     * Calculates and returns the number of elements in the queue.
     * @return number of elements
     */
    public int size() {
        int count = 0;
        Node<E> current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
 
    /**
     * Checks whether the queue is empty.
     * @return true if empty, false otherwise
     */

    public boolean isEmpty() {
        return front == null;
    }
 
   /**
     * Adds an element to the end of the queue.
     * @param element the element to be added
     */
    public void put(E element) {
        Node<E> node = new Node<>(element);
        if (isEmpty()) {
            front = rear = node; // First element in the queue
        } else {
            rear.next = node; // Link the new node at the end
            rear = node; // Update rear to the new node
        }
    }
 
    // Removes and returns the first element
    public E get() {
        if (isEmpty()) {
            return null;
        }
        E value = front.data; // Get the front value
        front = front.next;   // Move front pointer forward
        if (front == null) {
            rear = null; // Queue is empty after removal
        }
        return value;
    }
}
