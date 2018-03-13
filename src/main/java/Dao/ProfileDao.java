package Dao;

import Model.Profile;
import Model.Role;

import java.util.List;

public interface ProfileDao {

    Profile create (Profile profile);

    Profile update (long profileId, String username, String bio, String location, String web, String profilePicUrl, Role role);

    boolean delete (long profileId);

    List<Profile> findAll();
}
