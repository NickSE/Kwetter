package Model;

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

    //Make empty trend list, search for trends, add trends to empty list if there are any.
    public void setContainingKweet(Kweet containingKweet) {
        this.containingKweet = containingKweet;
    }
}
