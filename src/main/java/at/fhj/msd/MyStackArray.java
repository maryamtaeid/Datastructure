package at.fhj.msd;

public class MyStackArray<E> {
    private E[] data;
    private int top;

    @SuppressWarnings("unchecked")
    public MyStackArray() {
        data = (E[]) new Object[10]; // initial capacity = 10
        top = 0;
    }

    // Returns the number of elements in the stack
    public int size() {
        return top;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == 0;
    }

    // Pushes an element on top of the stack
    public void push(E element) {
        if (top == data.length) {
            resize(); // double the array size when full
        }
        data[top] = element;
        top++;
    }

    // Removes and returns the top element of the stack
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        top--;
        E value = data[top];
        data[top] = null; // free memory
        return value;
    }

    // Resizes the internal array (doubles its size)
    @SuppressWarnings("unchecked")
    private void resize() {
        E[] newData = (E[]) new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
