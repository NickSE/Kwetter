public class Trend {

    private String trend;
    private Kweet containingKweet;

    public Trend(String trend, Kweet containingKweet) {
        this.trend = trend;
        this.containingKweet = containingKweet;
    }

    public String getTrend() {
        return trend;
    }

    public Kweet getContainingKweet() {
        return containingKweet;
    }
}
