package Service;

import Dao.KweetDao;
import Dao.KweetDaoImp;
import Dao.ProfileDao;
import Dao.ProfileDaoImp;
import Model.Kweet;

<<<<<<< HEAD
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
=======
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
>>>>>>> 71054217503d3b624b35d184154c99c3d12e44f2
import java.util.Date;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("kweets")
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

    public void removeKweet (Kweet kweet) {
        kweetDao.delete(kweet);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getall")
    public List<Kweet> getKweets() {
        return kweetDao.findAll();
    }

    @POST
    @Path("{kweetId}/{ownerId}/{content}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postKweet(@PathParam("kweetId") Long kweetId, @PathParam("ownerId") String ownerId, @PathParam("content") String kweetContent) {
        Date postDate = new Date();
        Kweet kweet = new Kweet(kweetId, ownerId, kweetContent, postDate);
        System.out.println(kweet);
//        return kweetDao.create(kweet);
        return Response.ok(kweet).build();
    }

//    public Kweet getKweet(Long id) {
//        return kweetDao.find(id);
//    }

}
