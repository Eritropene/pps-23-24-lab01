package tdd2;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

/**
 * The test suite for testing the CircularIterableList implementation
 */
public class CircularIterableListTest {
    
    private CircularIterableList createEmptyList() {
        return new CircularIterableListImpl();
    }
    private CircularIterableList createFilledList() {
        return new CircularIterableListImpl(List.of(1,2,3));
    }

    @Test
    void testInitialEmptySize() {
        CircularIterableList list = createEmptyList();
        assertEquals(list.size(), 0);
    }

    @Test
    void testInitialSize() {
        CircularIterableList list = createFilledList();
        assertEquals(list.size(), 3);
    }

    @Test
    void testIfEmptyListIsEmpty() {
        CircularIterableList list = createEmptyList();
        assertTrue(list.isEmpty());
    }

    @Test
    void testIfFilledListIsNotEmpty() {
        CircularIterableList list = createFilledList();
        assertFalse(list.isEmpty());
    }

    @Test
    void testAddElement() {
        CircularIterableList list = createEmptyList();
        list.add(1);
        list.add(2);
        assertEquals(list.size(), 2);
    }

    @Test
    void testGetForwardIterator() {
        CircularIterableList list = createFilledList();
        assertTrue(list.getForwardIterator() instanceof Iterator);
    }

    @Test
    void testGetBackwardIterator() {
        CircularIterableList list = createFilledList();
        assertTrue(list.getBackwardIterator() instanceof Iterator);
    }

    @Test
    void testHasNextInForwardIterator() {
        CircularIterableList list = createFilledList();
        var forwardIterator = list.getForwardIterator();
        assertTrue(forwardIterator.hasNext());
    }

    @Test
    void testHasNextInBackwardIterator() {
        CircularIterableList list = createFilledList();
        var backwardIterator = list.getBackwardIterator();
        assertTrue(backwardIterator.hasNext());
    }

    @Test
    void testGetNextInForwardIterator() {
        CircularIterableList list = createFilledList();
        var forwardIterator = list.getForwardIterator();
        assertEquals(forwardIterator.next().get(), 1);
    }

    @Test
    void testGetNextInBackwardIterator() {
        CircularIterableList list = createFilledList();
        var backwardIterator = list.getBackwardIterator();
        assertEquals(backwardIterator.next().get(), 3);
    }

    @Test
    void testCycleListWithForwardIterator() {
        CircularIterableList list = createFilledList();
        var forwardIterator = list.getForwardIterator();
        final int iterations = 5;
        for (int i=0; i<iterations; i++) {
            forwardIterator.next();
        }
        assertEquals(forwardIterator.next().get(), 3);
    }

    @Test
    void testCycleListWithBackwardIterator() {
        CircularIterableList list = createFilledList();
        var backwardIterator = list.getBackwardIterator();
        final int iterations = 5;
        for (int i=0; i<iterations; i++) {
            backwardIterator.next();
        }
        assertEquals(backwardIterator.next().get(), 1);
    }

    @Test
    void testHasNextInEmptyForwardIterator() {
        CircularIterableList list = createEmptyList();
        var forwardIterator = list.getForwardIterator();
        assertFalse(forwardIterator.hasNext());
    }

    @Test
    void testHasNextInEmptyBackwardIterator() {
        CircularIterableList list = createEmptyList();
        var backwardIterator = list.getBackwardIterator();
        assertFalse(backwardIterator.hasNext());
    }

    @Test
    void testGetNextInEmptyForwardIterator() {
        CircularIterableList list = createEmptyList();
        var forwardIterator = list.getForwardIterator();
        assertFalse(forwardIterator.next().isPresent());
    }

    @Test
    void testGetNextInEmptyBackwardIterator() {
        CircularIterableList list = createEmptyList();
        var backwardIterator = list.getBackwardIterator();
        assertFalse(backwardIterator.next().isPresent());
    }
}
