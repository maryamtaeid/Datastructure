package at.fhj.msd;
public class MyStackArray<E> {
    private E[] data;
    private int top;

    @SuppressWarnings("unchecked")
    public MyStackArray() {
        data = (E[]) new Object[10]; // Initial size = 10
        top = 0;
    }

    // Returns the number of elements
    public int size() {
        return top;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == 0;
    }

    // Adds element on top
    public void push(E element) {
        if (top == data.length) {
            resize();
        }
        data[top] = element;
        top++;
    }

    // Removes and returns the top element
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        top--;
        E value = data[top];
        data[top] = null;
        return value;
    }

    // Doubles the array size when full
    @SuppressWarnings("unchecked")
    private void resize() {
        E[] bigger = (E[]) new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            bigger[i] = data[i];
        }
        data = bigger;
    }
}
