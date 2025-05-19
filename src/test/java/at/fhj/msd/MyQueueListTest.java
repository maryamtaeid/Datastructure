package at.fhj.msd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MyQueueListTest {

    @Test
    public void testNewQueueIsEmpty() {
        MyQueueList<String> queue = new MyQueueList<>();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertNull(queue.get());
    }

    @Test
    public void testPutAndGetInOrder() {
        MyQueueList<Integer> queue = new MyQueueList<>();
        queue.put(10);
        queue.put(20);
        queue.put(30);

        assertFalse(queue.isEmpty());
        assertEquals(3, queue.size());

        assertEquals(10, queue.get());
        assertEquals(20, queue.get());
        assertEquals(30, queue.get());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testGetFromEmptyQueueReturnsNull() {
        MyQueueList<String> queue = new MyQueueList<>();
        assertNull(queue.get());

        queue.put("A");
        assertEquals("A", queue.get());
        assertNull(queue.get());
    }

    @Test
    public void testMultiplePutAndGet() {
        MyQueueList<Integer> queue = new MyQueueList<>();
        for (int i = 0; i < 100; i++) {
            queue.put(i);
        }

        assertEquals(100, queue.size());

        for (int i = 0; i < 100; i++) {
            assertEquals(i, queue.get());
        }

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPutNullThrowsException() {
        MyQueueList<String> queue = new MyQueueList<>();
        assertThrows(NullPointerException.class, () -> queue.put(null));
    }

    @Test
    public void testSizeAfterEachOperation() {
        MyQueueList<Integer> queue = new MyQueueList<>();
        assertEquals(0, queue.size());

        queue.put(1);
        assertEquals(1, queue.size());

        queue.put(2);
        assertEquals(2, queue.size());

        queue.get();
        assertEquals(1, queue.size());

        queue.get();
        assertEquals(0, queue.size());
    }
}
