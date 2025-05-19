package at.fhj.msd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MyQueueArrayTest {

    @Test
    public void testNewQueueIsEmpty() {
        MyQueueArray<String> queue = new MyQueueArray<>();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertNull(queue.get());
    }

    @Test
    public void testPutAndGetInOrder() {
        MyQueueArray<Integer> queue = new MyQueueArray<>();
        queue.put(1);
        queue.put(2);
        queue.put(3);

        assertEquals(3, queue.size());
        assertEquals(1, queue.get());
        assertEquals(2, queue.get());
        assertEquals(3, queue.get());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testWrapAroundBehavior() {
        MyQueueArray<Integer> queue = new MyQueueArray<>();

        // Fill queue near capacity (10 elements, since capacity = 11 with 1 extra)
        for (int i = 0; i < 10; i++) {
            queue.put(i);
        }

        // Remove 5 elements
        for (int i = 0; i < 5; i++) {
            assertEquals(i, queue.get());
        }

        // Add 5 more to force wrap-around
        for (int i = 10; i < 15; i++) {
            queue.put(i);
        }

        // Now check remaining elements (5–14)
        for (int i = 5; i < 15; i++) {
            assertEquals(i, queue.get());
        }

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testAutomaticResize() {
        MyQueueArray<Integer> queue = new MyQueueArray<>();

        // Insert more than initial capacity (10 actual data slots)
        for (int i = 0; i < 25; i++) {
            queue.put(i);
        }

        assertEquals(25, queue.size());

        for (int i = 0; i < 25; i++) {
            assertEquals(i, queue.get());
        }

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testGetFromEmptyQueueReturnsNull() {
        MyQueueArray<String> queue = new MyQueueArray<>();
        assertNull(queue.get());
        queue.put("A");
        queue.get();
        assertNull(queue.get());
    }

    @Test
    public void testNullPutThrowsException() {
        MyQueueArray<String> queue = new MyQueueArray<>();
        assertThrows(NullPointerException.class, () -> queue.put(null));
    }
}
