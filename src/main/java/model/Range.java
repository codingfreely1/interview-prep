package model;

/**
 * Created by yael on 04/02/17.
 */
public class Range {
    public int start;
    public int end;

    public Range(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Range range = (Range) o;

        if (start != range.start) return false;
        return end == range.end;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }
}
