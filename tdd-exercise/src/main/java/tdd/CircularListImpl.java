package tdd;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{

    private List<Integer> list;
    private int cursor;

    public CircularListImpl(List<Integer> list) {
        this.list = new ArrayList<>(list);
        reset();
    }

    public CircularListImpl() {
        this.list = new ArrayList<>();
        reset();
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
        incrementCursor();
        return getCurrentElement();
    }

    @Override
    public Optional<Integer> previous() {
        decrementCursor();
        return getCurrentElement();
    }

    @Override
    public void reset() {
        this.cursor = -1;
    }

    private void incrementCursor() {
        this.cursor += 1;
        if (this.cursor >= this.size())
            this.cursor = 0;
    }

    private void decrementCursor() {
        this.cursor -= 1;
        if (this.cursor < 0)
            this.cursor = this.size() - 1;
    }

    private Optional<Integer> getCurrentElement() {
        if (isEmpty()) 
            return Optional.empty();
        else
            return Optional.of(this.list.get(this.cursor));
    }
}
