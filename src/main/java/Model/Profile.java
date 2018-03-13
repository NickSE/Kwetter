package Model;

import java.util.List;

public class Profile {

    private Long profileId;
    private String username;
    private String bio;
    private String location;
    private String web;
    private List<String> following;
    private List<String> followers;
    private String profilePicUrl;
    private Role role;

    public Profile(Long profileId, String username, Role role) {
        this.profileId = profileId;
        this.username = username;
        this.role = role;
    }

    public Profile(Long profileId, String username, String bio, String location, String web, String profilePicUrl, Role role) {
        this.profileId = profileId;
        this.username = username;
        this.bio = bio;
        this.location = location;
        this.web = web;
        this.profilePicUrl = profilePicUrl;
        this.role = role;
    }

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
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
