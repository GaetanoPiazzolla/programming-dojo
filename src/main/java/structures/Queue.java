package structures;

import java.util.ArrayList;

public class Queue<T> {

    private final ArrayList<T> values;

    public Queue() {
        values = new ArrayList<>();
    }

    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element could not be null");
        }
        values.add(element);
    }

    public T remove() {
        return values.remove(0);
    }

    public T peek() {
        return values.get(0);
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

}
