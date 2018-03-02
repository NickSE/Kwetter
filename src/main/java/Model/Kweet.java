package Model;

import java.util.Date;
import java.util.List;

public class Kweet {

    private long kweetId;
    private String ownerId;
    private String kweet;
    private Date postDate;
    private List<Profile> likes;
    private List<String> mentions;
    private List<String> trends;

    public Kweet(long kweetId, String ownerId, String kweet, Date postDate) {
        this.kweetId = kweetId;
        this.ownerId = ownerId;
        this.kweet = kweet;
        this.postDate = postDate;
    }

    public Kweet(String ownerId, String kweet, Date postDate, List<String> mentions, List<String> trends) {
        this.ownerId = ownerId;
        this.kweet = kweet;
        this.postDate = postDate;
        this.mentions = mentions;
        this.trends = trends;
    }

    public long getKweetId() {
        return kweetId;
    }

    public void setKweetId(long kweetId) {
        this.kweetId = kweetId;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getKweet() {
        return kweet;
    }

    public void setKweet(String kweet) {
        this.kweet = kweet;
    }

    public Date getPostDate() {
        return postDate;
    }

    public List<Profile> getLikes() {
        return likes;
    }

    public void setLikes(List<Profile> likes) {
        this.likes = likes;
    }

    public List<String> getMentions() {
        return mentions;
    }

    public void setMentions(List<String> mentions) {
        this.mentions = mentions;
    }

    public List<String> getTrends() {
        return trends;
    }

    public void setTrends(List<String> trends) {
        this.trends = trends;
    }
}
