package at.fhj.msd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MyStackListTest {

    @Test
    public void testNewStackIsEmpty() {
        MyStackList<Integer> stack = new MyStackList<>();
        assertTrue(stack.isEmpty(), "New stack should be empty");
        assertEquals(0, stack.size(), "New stack size should be 0");
    }

    @Test
    public void testPushIncreasesSize() {
        MyStackList<String> stack = new MyStackList<>();
        stack.push("A");
        assertFalse(stack.isEmpty(), "Stack should not be empty after push");
        assertEquals(1, stack.size());

        stack.push("B");
        assertEquals(2, stack.size());
    }

    @Test
    public void testPopOrder() {
        MyStackList<String> stack = new MyStackList<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals("C", stack.pop(), "First pop should return 'C'");
        assertEquals("B", stack.pop(), "Second pop should return 'B'");
        assertEquals("A", stack.pop(), "Third pop should return 'A'");
        assertNull(stack.pop(), "Pop on empty stack should return null");
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopFromEmptyStackReturnsNull() {
        MyStackList<Double> stack = new MyStackList<>();
        assertNull(stack.pop(), "Pop from empty stack should return null");
    }

    @Test
    public void testPushAndPopInterleaved() {
        MyStackList<Integer> stack = new MyStackList<>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());

        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }
}
