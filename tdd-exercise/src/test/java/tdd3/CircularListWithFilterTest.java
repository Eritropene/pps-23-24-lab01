package tdd3;

import org.junit.jupiter.api.Test;

import tdd.CircularListTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CircularListWithFilterTest extends CircularListTest {

    @Override
    protected CircularListWithFilter createEmptyList() {
        return new CircularListWithFilter();
    }

    @Override
    protected CircularListWithFilter createFilledList() {
        return new CircularListWithFilter(List.of(1,2,3)); 
    }

    @Test
    void testFindValueWithFilteredNext() {
        CircularListWithFilter list = createFilledList();
        var foundValue = list.filteredNext(i -> i > 2);
        assertEquals(foundValue.get(), 3);
    }

    @Test
    void testFindNothingWithFilteredNext() {
        CircularListWithFilter list = createFilledList();
        var foundValue = list.filteredNext(i -> false);
        assertTrue(foundValue.isEmpty());
    }

    @Test
    void testFindNothingWithFilteredNextInEmptyList() {
        CircularListWithFilter list = createEmptyList();
        var foundValue = list.filteredNext(i -> i==3);
        assertTrue(foundValue.isEmpty());
    }
}
