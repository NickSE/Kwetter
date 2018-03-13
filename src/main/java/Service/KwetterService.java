package Service;

import Dao.KweetDao;
import Dao.KweetDaoImp;
import Dao.ProfileDao;
import Dao.ProfileDaoImp;
import Model.Kweet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

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

//    public Kweet getKweet(Long id) {
//        return kweetDao.find(id);
//    }

}
