package Model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="kweet")
@NamedQuery(name="Kweet.findAll", query="Select k FROM Kweet k")
public class Kweet implements Serializable {

    @Id
    @GeneratedValue
    private Long kweetId;
    private String ownerId;
    private String kweet;
    private Date postDate;
    @Transient
    private List<Profile> likes;
    @ElementCollection
    private List<String> mentions;
    @ElementCollection
    private List<String> trends;

    public Kweet(Long kweetId, String ownerId, String kweet, Date postDate) {
        this.kweetId = kweetId;
        this.ownerId = ownerId;
        this.kweet = kweet;
        this.postDate = postDate;
    }

    public Kweet(Long kweetId, String ownerId, String kweet, Date postDate, List<String> mentions, List<String> trends) {
        this.kweetId = kweetId;
        this.ownerId = ownerId;
        this.kweet = kweet;
        this.postDate = postDate;
        this.mentions = mentions;
        this.trends = trends;
    }

    public Kweet() {
    }

    public long getKweetId() {
        return kweetId;
    }

    public void setKweetId(Long kweetId) {
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
