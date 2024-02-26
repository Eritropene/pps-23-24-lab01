import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tdd.CircularList;

public class CircularListImpl implements CircularList{

    private List<Integer> list;
    private int cursor = 0;

    public CircularListImpl(List<Integer> list) {
        this.list = new ArrayList<>(list);
    }

    public CircularListImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> result;
        if (isEmpty()) 
            result = Optional.empty();
        else
            result = Optional.of(getCurrentElement());

        this.cursor += 1;
        return result;
    }

    @Override
    public Optional<Integer> previous() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'previous'");
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

    private int getCurrentElement() {
        return this.list.get( this.cursor % this.size() );
    }
}
