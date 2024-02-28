package tdd;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    protected CircularList createEmptyList() {
        return new CircularListImpl();
    }
    protected CircularList createFilledList() {
        return new CircularListImpl(List.of(1,2,3));
    }

    @Test
    void testInitialSizeOfEmptyList() {
        CircularList list = createEmptyList();
        assertEquals(list.size(), 0);
    }

    @Test
    void testInitialSizeOfFilledList() {
        CircularList list = createFilledList();
        assertEquals(list.size(), 3);
    }

    @Test
    void testAddElement() {
        CircularList list = createEmptyList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(list.size(), 3);
    }

    @Test
    void testIfEmptyListIsEmpty() {
        CircularList list = createEmptyList();
        assertTrue(list.isEmpty());
    }

    @Test
    void testIfFilledListIsNotEmpty() {
        CircularList list = createEmptyList();
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testGetNextElement() {
        CircularList list = createFilledList();
        int value = list.next().get();
        assertEquals(value, 1);
    }

    @Test 
    void testGetNextElementOfEmptyList() {
        CircularList list = createEmptyList();
        assertFalse(list.next().isPresent());
    }

    @Test
    void testGetMultipleNextElements() {
        CircularList list = createFilledList();
        list.next();
        list.next();
        int value = list.next().get();
        assertEquals(value, 3);
    }

    @Test
    void testGetNextElementAfterCycling() {
        CircularList list = createFilledList();
        list.next();
        list.next();
        list.next();
        int value = list.next().get();
        assertEquals(value, 1);
    }

    @Test
    void testGetPreviousElement() {
        CircularList list = createFilledList();
        int value = list.previous().get();
        assertEquals(value, 3);
    }

    @Test
    void testGetMultiplePreviousElements() {
        CircularList list = createFilledList();
        list.previous();
        list.previous();
        int value = list.previous().get();
        assertEquals(value, 1);
    }

    @Test
    void testGetPreviousElementAfterCycling() {
        CircularList list = createFilledList();
        list.previous();
        list.previous();
        list.previous();
        int value = list.previous().get();
        assertEquals(value, 3);
    }

    @Test
    void testGetNextAfterPreviousElement() {
        CircularList list = createFilledList();
        list.previous();
        int value = list.next().get();
        assertEquals(value, 1);
    }

    @Test
    void testGetPreviousAfterNextElement() {
        CircularList list = createFilledList();
        list.next();
        int value = list.previous().get();
        assertEquals(value, 3);
    }

    @Test
    void testResetList() {
        CircularList list = createFilledList();
        list.previous();
        list.previous();
        list.reset();
        int value = list.next().get();
        assertEquals(value, 1);
    }
}
