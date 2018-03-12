package Dao;

import Model.Profile;
import Model.Role;

public interface ProfileDao {

    Profile create (Profile profile);

    Profile update (long profileId, String username, String bio, String location, String web, String profilePicUrl, Role role);

    void delete (long profileId);
}
