package Service;

import Dao.ProfileDao;
import Dao.ProfileDaoImp;
import Model.Profile;
import Model.Role;

public class ProfileService {

    private final ProfileDao profileDao;

    public ProfileService(){
        profileDao = ProfileDaoImp.getProfileDao();
    }

    public Profile createProfile(Profile p){
        return profileDao.create(p);
    }

    public Profile updateProfile(long profileId, String username, String bio, String location, String web, String profilePicUrl, Role role){
        return profileDao.update(profileId, username, bio, location, web, profilePicUrl, role);
    }

    public void deleteProfile(long profileId){
        profileDao.delete(profileId);
    }

}
