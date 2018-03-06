package Service;

import Dao.KweetDao;
import Dao.KweetDaoImp;
import Dao.ProfileDao;
import Dao.ProfileDaoImp;
import Model.Kweet;

import java.util.Date;
import java.util.List;

public class KwetterService {

    private final KweetDao kweetDao;

    public KwetterService() {
        kweetDao = KweetDaoImp.getKweetDao();
    }

    public Kweet addKweet(Kweet k) {
        return kweetDao.create(k);
    }

    public Kweet editKweet(long kweetId, String ownerId, String kweet, Date postDate) {
        return kweetDao.update(kweetId, ownerId, kweet, postDate);
    }

    public void removeKweet (long kweetId) {
        kweetDao.delete(kweetId);
    }

    public List<Kweet> getKweets() {
        return kweetDao.findAll();
    }

    public Kweet getKweet(Long id) {
        return kweetDao.find(id);
    }

}
