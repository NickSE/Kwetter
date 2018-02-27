import java.util.List;

public class Profile {

    private String username;
    private String bio;
    private String location;
    private String web;
    private List<String> following;
    private List<String> followers;
    private String profilePicUrl;
    private Role role;

    public Profile(String username, String bio, String location, String web, String profilePicUrl, Role role) {
        this.username = username;
        this.bio = bio;
        this.location = location;
        this.web = web;
        this.profilePicUrl = profilePicUrl;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public String getWeb() {
        return web;
    }

    public List<String> getFollowing() {
        return following;
    }

    public void setFollowing(List<String> following) {
        this.following = following;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
