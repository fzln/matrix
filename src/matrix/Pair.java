package matrix;

/**
 * Created by f on 19.05.16.
 *
 */
public class Pair {
    private int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {

        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" + "first=" + first + ", second=" + second + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (first != pair.first) return false;
        return second == pair.second;
    }

    @Override
    public int hashCode() {
        int result = first;
        result = 31 * result + second;
        return result;
    }
}
