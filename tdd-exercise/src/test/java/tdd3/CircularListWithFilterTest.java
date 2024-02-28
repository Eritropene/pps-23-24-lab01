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

    
}