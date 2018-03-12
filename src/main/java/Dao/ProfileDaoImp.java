package Dao;

import Model.Profile;
import Model.Role;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ProfileDaoImp implements ProfileDao{

    private static ProfileDaoImp instance = null;
    private AtomicLong nextId = new AtomicLong(0L);
    private ConcurrentHashMap<Long, Profile> profiles;

    public static synchronized ProfileDao getProfileDao() {
        if (instance == null) {
            instance = new ProfileDaoImp();
        }
        return instance;
    }

    private ProfileDaoImp() { this.constructor(); }

    public void constructor() {
        profiles = new ConcurrentHashMap<>();

        create(new Profile(nextId.getAndIncrement(), "Nick", new Role(true, true, true, "Admin")));
    }


    @Override
    public Profile create(Profile profile) {
        if (profile == null) {
            throw new IllegalArgumentException("Profile is null");
        }

        profiles.put(profile.getProfileId(), profile);
        return profile;
    }

    @Override
    public Profile update(long profileId, String username, String bio, String location, String web, String profilePicUrl, Role role) {
        if (username == null || bio == null || location == null || web == null || profilePicUrl == null || role == null) {
            throw new IllegalArgumentException("Username, bio, location, web, profilePicUrl or role are null");
        }
        if (!profiles.containsKey(profileId)) {
            throw new IllegalArgumentException("KweetId not found: " + profileId);
        }

        Profile p = profiles.get(profileId);
        p.setUsername(username);
        p.setBio(bio);
        p.setLocation(location);
        p.setWeb(web);
        p.setProfilePicUrl(profilePicUrl);
        p.setRole(role);

        return p;
    }

    @Override
    public void delete(long profileId) {
        if (!profiles.containsKey(profileId)) {
            throw new IllegalArgumentException("Id not found: " + profileId);
        }

        profiles.remove(profileId);
    }
}
