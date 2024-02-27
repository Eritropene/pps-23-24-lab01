package tdd2;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

/**
 * The test suite for testing the CircularIterableList implementation
 */
public class CircularIterableListTest {
    
    @Test
    void testInitialEmptySize() {
        CircularIterableList list = new CircularIterableList();
        assertEquals(list.size(), 0);
    }

    @Test
    void testInitialSize() {
        CircularIterableList list = new CircularIterableList(List.of(1,2,3));
        assertEquals(list.size(), 3);
    }

    @Test
    void testIfEmptyListIsEmpty() {
        CircularIterableList list = new CircularIterableList();
        assertTrue(list.isEmpty());
    }

    @Test
    void testIfFilledListIsNotEmpty() {
        CircularIterableList list = new CircularIterableList(List.of(1, 2, 3));
        assertFalse(list.isEmpty());
    }

    @Test
    void testAddElement() {
        CircularIterableList list = new CircularIterableList();
        list.add(1);
        list.add(2);
        assertEquals(list.size(), 2);
    }

    @Test
    void testGetForwardIterator() {
        CircularIterableList list = new CircularIterableList(List.of(1, 2, 3));
        assertTrue(list.getForwardIterator() instanceof Iterator);
    }

    @Test
    void testGetBackwardIterator() {
        CircularIterableList list = new CircularIterableList(List.of(1, 2, 3));
        assertTrue(list.getBackwardIterator() instanceof Iterator);
    }

    @Test
    void testHasNextInForwardIterator() {
        CircularIterableList list = new CircularIterableList(List.of(1, 2, 3));
        var forwardIterator = list.getForwardIterator();
        assertTrue(forwardIterator.hasNext());
    }

    @Test
    void testHasNextInBackwardIterator() {
        CircularIterableList list = new CircularIterableList(List.of(1, 2, 3));
        var backwardIterator = list.getBackwardIterator();
        assertTrue(backwardIterator.hasNext());
    }

    @Test
    void testGetNextInForwardIterator() {
        CircularIterableList list = new CircularIterableList(List.of(1, 2, 3));
        var forwardIterator = list.getForwardIterator();
        assertEquals(forwardIterator.next().get(), 1);
    }

    @Test
    void testGetNextInBackwardIterator() {
        CircularIterableList list = new CircularIterableList(List.of(1, 2, 3));
        var backwardIterator = list.getBackwardIterator();
        assertEquals(backwardIterator.next().get(), 3);
    }

    @Test
    void testCycleListWithForwardIterator() {
        CircularIterableList list = new CircularIterableList(List.of(1, 2, 3));
        var forwardIterator = list.getForwardIterator();
        final int iterations = 5;
        for (int i=0; i<iterations; i++) {
            forwardIterator.next();
        }
        assertEquals(forwardIterator.next().get(), 3);
    }

    @Test
    void testCycleListWithBackwardIterator() {
        CircularIterableList list = new CircularIterableList(List.of(1, 2, 3));
        var backwardIterator = list.getBackwardIterator();
        final int iterations = 5;
        for (int i=0; i<iterations; i++) {
            backwardIterator.next();
        }
        assertEquals(backwardIterator.next().get(), 1);
    }

    @Test
    void testHasNextInEmptyForwardIterator() {
        CircularIterableList list = new CircularIterableList();
        var forwardIterator = list.getForwardIterator();
        assertFalse(forwardIterator.hasNext());
    }

    @Test
    void testHasNextInEmptyBackwardIterator() {
        CircularIterableList list = new CircularIterableList();
        var backwardIterator = list.getBackwardIterator();
        assertFalse(backwardIterator.hasNext());
    }

    @Test
    void testGetNextInEmptyForwardIterator() {
        CircularIterableList list = new CircularIterableList();
        var forwardIterator = list.getForwardIterator();
        assertFalse(forwardIterator.next().isPresent());
    }

    @Test
    void testGetNextInEmptyBackwardIterator() {
        CircularIterableList list = new CircularIterableList();
        var backwardIterator = list.getBackwardIterator();
        assertFalse(backwardIterator.next().isPresent());
    }
}
