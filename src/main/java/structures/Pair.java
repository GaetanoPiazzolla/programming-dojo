package structures;

import java.util.Objects;

public class Pair<T,V>{

    private T left;
    private V right;

    public Pair(T left, V right) {
        this.left = left;
        this.right=right;
    }

    public static Pair of(Object left, Object right) {
        return new Pair(left,right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(left, pair.left) && Objects.equals(right, pair.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
