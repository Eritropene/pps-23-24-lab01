package tdd2;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import tdd.CircularList;
import tdd.CircularListImpl;

public class CircularIterableListImpl implements CircularIterableList {

    private CircularList list;

    public CircularIterableListImpl(List<Integer> list) {
        this.list = new CircularListImpl(list);
    }

    public CircularIterableListImpl() {
        this.list = new CircularListImpl();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
	public int size() {
		return this.list.size();
	}

    @Override
	public void add(int element) {
		this.list.add(element);
	}

    @Override
    public Iterator<Optional<Integer>> getForwardIterator() {
        return new Iterator<Optional<Integer>>() {

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Optional<Integer> next() {
                return list.next();
            }

        };
    }

    @Override
    public Iterator<Optional<Integer>> getBackwardIterator() {
        return new Iterator<Optional<Integer>>() {

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Optional<Integer> next() {
                return list.previous();
            }

        };
    }

}
