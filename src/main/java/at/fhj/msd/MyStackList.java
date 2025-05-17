package at.fhj.msd;

public class MyStackList<E> {
    private Node<E> head;

    // Inner node class
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyStackList() {
        head = null;
    }

    // Calculates and returns the number of elements
    public int size() {
        int count = 0;
        Node<E> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Adds an element to the top of the stack
    public void push(E element) {
        Node<E> node = new Node<>(element);
        node.next = head;
        head = node;
    }

    // Removes and returns the top element
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E value = head.data;
        head = head.next;
        return value;
    }
}
