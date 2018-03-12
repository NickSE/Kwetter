package Model;

public class Mention {

    private Profile profile;
    private Kweet containingKweet;

    public Mention(Profile profile, Kweet containingKweet) {
        this.profile = profile;
        this.containingKweet = containingKweet;
    }

    public Profile getProfile() {
        return profile;
    }

    public Kweet getContainingKweet() {
        return containingKweet;
    }

    //Make empty mention list, search for mentions, add mentions to empty list if there are any.
    public void setContainingKweet(Kweet containingKweet) {
        this.containingKweet = containingKweet;
    }
}
