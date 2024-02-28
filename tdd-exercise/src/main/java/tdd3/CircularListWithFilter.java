package tdd3;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import tdd.CircularListImpl;

public class CircularListWithFilter extends CircularListImpl {

    public CircularListWithFilter(List<Integer> list) {
        super(list);
    }

    public CircularListWithFilter() {
        super();
    }

    public Optional<Integer> filteredNext(final Predicate<Integer> condition) {
        for (int i=0; i < this.size(); i++) {
            int value = this.next().get();

            if (condition.test(value))
                return Optional.of(value);
        }
        return Optional.empty();
    }

}
