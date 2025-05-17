package at.fhj.msd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MyStackArrayTest {

    @Test
    public void testNewStackIsEmpty() {
        MyStackArray<String> stack = new MyStackArray<>();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPushIncreasesSize() {
        MyStackArray<Integer> stack = new MyStackArray<>();
        stack.push(10);
        stack.push(20);
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
    }

    @Test
    public void testPopReturnsElementsInLIFOOrder() {
        MyStackArray<String> stack = new MyStackArray<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopOnEmptyStackReturnsNull() {
        MyStackArray<Double> stack = new MyStackArray<>();
        assertNull(stack.pop());
    }

    @Test
    public void testPushAndPopInterleaved() {
        MyStackArray<Integer> stack = new MyStackArray<>();
        stack.push(1);
        assertEquals(1, stack.pop());

        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testResizeBeyondInitialCapacity() {
        MyStackArray<Integer> stack = new MyStackArray<>();

        // push more than 10 elements to trigger resize
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }

        assertEquals(15, stack.size());

        // check LIFO behavior after resize
        for (int i = 14; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }

        assertTrue(stack.isEmpty());
    }
}
