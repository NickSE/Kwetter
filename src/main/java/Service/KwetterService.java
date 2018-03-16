package Service;

import Dao.KweetDao;
import Dao.KweetDaoImp;
import Dao.ProfileDao;
import Dao.ProfileDaoImp;
import Model.Kweet;

<<<<<<< HEAD
import javax.ws.rs.*;
=======
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
>>>>>>> 73f3620ac49c51d80838ccfa9afdb94dbf12472c
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

<<<<<<< HEAD
@Path("/kweets")
=======
@Path("kweets")
>>>>>>> 73f3620ac49c51d80838ccfa9afdb94dbf12472c
public class KwetterService {

    private final KweetDao kweetDao;

    public KwetterService() {
        kweetDao = KweetDaoImp.getKweetDao();
    }

    public void addKweet(Kweet k) {
        kweetDao.create(k);
    }

    public void editKweet(Kweet kweet) {
        kweetDao.update(kweet);
    }

    public void removeKweet (Long kweetId) {
        kweetDao.delete(kweetId);
    }

    @PUT
    @Produces(APPLICATION_JSON)
    @Path("/update/{kweetId}/{ownerId}/{content}")
    public Response editKweet(@PathParam("kweetId") Long kweetId, @PathParam("ownerId") String ownerId, @PathParam("content") String kweetContent) {
        Date date = new Date();
        Kweet kweet = new Kweet(kweetId, ownerId, kweetContent, date);
        kweetDao.update(kweet);
        return Response.ok(kweet).build();
    }

    @DELETE
    @Produces(APPLICATION_JSON)
    @Path("/delete/{kweetId}")
    public Response deleteKweet(@PathParam("kweetId") Long kweetId) {
        if (kweetDao.delete(kweetId)) {
            return Response.ok("Kweet met id: " + kweetId + " succesvol verwijderd!").build();
        }
        else {
            return Response.ok("Niet verwijderd!").build();
        }
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/getall")
    public List<Kweet> getKweets() {
        return kweetDao.findAll();
    }

    @POST
    @Path("{kweetId}/{ownerId}/{content}")
<<<<<<< HEAD
    @Produces(APPLICATION_JSON)
    public Response postKweet(@PathParam("kweetId") Long kweetId, @PathParam("ownerId") String ownerId, @PathParam("content") String kweetContent) {
        Date postDate = new Date();
        Kweet kweet = new Kweet(kweetId, ownerId, kweetContent, postDate);
        kweetDao.create(kweet);
        return Response.ok(kweet).build();
    }
=======
    @Produces(MediaType.APPLICATION_JSON)
    public Response postKweet(@PathParam("kweetId") Long kweetId, @PathParam("ownerId") String ownerId, @PathParam("content") String kweetContent) {
        try {
            Date postDate = new Date();
            Kweet kweet = new Kweet(kweetId, ownerId, kweetContent, postDate);
            System.out.println(kweet);
//        return kweetDao.create(kweet);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return Response.ok("Gelukt!").build();
    }

>>>>>>> 73f3620ac49c51d80838ccfa9afdb94dbf12472c
//    public Kweet getKweet(Long id) {
//        return kweetDao.find(id);
//    }

}
