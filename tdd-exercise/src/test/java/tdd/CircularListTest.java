package tdd;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    @Test
    void testInitialSize() {
        CircularList list = new CircularListImpl(List.of(1, 2, 3));
        assertEquals(list.size(), 3);
    }

    @Test
    void testAddElement() {
        CircularList list = new CircularListImpl();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(list.size(), 3);
    }

    @Test
    void testIfEmptyListIsEmpty() {
        CircularList list = new CircularListImpl();
        assertTrue(list.isEmpty());
    }

    @Test
    void testIfFilledListIsNotEmpty() {
        CircularList list = new CircularListImpl();
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testGetNextElement() {
        CircularList list = new CircularListImpl(List.of(1, 2, 3));
        int value = list.next().get();
        assertEquals(value, 1);
    }

    @Test 
    void testGetNextElementOfEmptyList() {
        CircularList list = new CircularListImpl();
        assertFalse(list.next().isPresent());
    }

    @Test
    void testGetMultipleNextElements() {
        CircularList list = new CircularListImpl(List.of(1, 2, 3));
        list.next();
        list.next();
        int value = list.next().get();
        assertEquals(value, 3);
    }

    @Test
    void testGetNextElementAfterCycling() {
        CircularList list = new CircularListImpl(List.of(1, 2, 3));
        list.next();
        list.next();
        list.next();
        int value = list.next().get();
        assertEquals(value, 1);
    }

    @Test
    void testGetPreviousElement() {
        CircularList list = new CircularListImpl(List.of(1, 2, 3));
        int value = list.previous().get();
        assertEquals(value, 3);
    }

    @Test
    void testGetMultiplePreviousElements() {
        CircularList list = new CircularListImpl(List.of(1, 2, 3));
        list.previous();
        list.previous();
        int value = list.previous().get();
        assertEquals(value, 1);
    }

    @Test
    void testGetPreviousElementAfterCycling() {
        CircularList list = new CircularListImpl(List.of(1, 2, 3));
        list.previous();
        list.previous();
        list.previous();
        int value = list.previous().get();
        assertEquals(value, 3);
    }

    @Test
    void testGetNextAfterPreviousElement() {
        CircularList list = new CircularListImpl(List.of(1, 2, 3));
        list.previous();
        int value = list.next().get();
        assertEquals(value, 1);
    }

    @Test
    void testGetPreviousAfterNextElement() {
        CircularList list = new CircularListImpl(List.of(1, 2, 3));
        list.next();
        int value = list.previous().get();
        assertEquals(value, 3);
    }

    @Test
    void testResetList() {
        CircularList list = new CircularListImpl(List.of(1, 2, 3));
        list.previous();
        list.previous();
        list.reset();
        int value = list.next().get();
        assertEquals(value, 1);
    }
}
