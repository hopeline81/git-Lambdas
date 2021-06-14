package taxi.models;

public class Range {
    private int low;
    private  int high;

    public Range(int low, int high) {
        this.low = low;
        this.high = high;
    }

    @Override
    public String toString() {
        return "low - " + low + " " + "high - " + high;
    }
}
