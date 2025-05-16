package at.fhj.msd;
public class MyStackList<E> {
    private Node<E> head;
    private int size;

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
        size = 0;
    }

    // Returns number of elements
    public int size() {
        return size;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Adds element on top
    public void push(E element) {
        Node<E> node = new Node<>(element);
        node.next = head;
        head = node;
        size++;
    }

    // Removes and returns the top element
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E value = head.data;
        head = head.next;
        size--;
        return value;
    }
}
