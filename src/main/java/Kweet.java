import java.util.Date;
import java.util.List;

public class Kweet {

    private String ownerId;
    private String kweet;
    private Date postDate;
    private List<Profile> likes;
    private List<String> mentions;
    private List<String> trends;

    public Kweet(String ownerId, String kweet, Date postDate) {
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
}
