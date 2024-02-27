package tdd2;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import tdd.CircularList;
import tdd.CircularListImpl;

public class CircularIterableList {

    private CircularList list;

    public CircularIterableList(List<Integer> list) {
        this.list = new CircularListImpl(list);
    }

    public CircularIterableList() {
        this.list = new CircularListImpl();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

	public Integer size() {
		return this.list.size();
	}

	public void add(int element) {
		this.list.add(element);
	}

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
