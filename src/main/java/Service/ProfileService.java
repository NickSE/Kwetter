package Service;

import Dao.ProfileDao;
import Dao.ProfileDaoImp;
import Model.Kweet;
import Model.Profile;
import Model.Role;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/profile")
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

    @DELETE
    @Produces(APPLICATION_JSON)
    @Path("/delete/{profileId}")
    public Response deleteProfile(@PathParam("profileId") Long profileId) {
        if (profileDao.delete(profileId)) {
            return Response.ok("Kweet met id: " + profileId + " succesvol verwijderd!").build();
        }
        else {
            return Response.ok("Niet verwijderd!").build();
        }
    }

    @POST
    @Produces(APPLICATION_JSON)
    @Path("/{profileId}/{username}")
    public Response createProfile(@PathParam("profileId") Long profileId, @PathParam("username") String username) {
        Profile profile = new Profile(profileId, username, new Role(true, true, true, "Admin"));
        profileDao.create(profile);
        return Response.ok(profile).build();
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/getall")
    public List<Profile> getKweets() {
        return profileDao.findAll();
    }

}
