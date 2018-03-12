package Dao;

import Model.Kweet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class KweetDaoImp implements KweetDao{

    private static KweetDaoImp instance = null;
    private AtomicLong nextId = new AtomicLong(0L);
    private ConcurrentHashMap<Long, Kweet> kweets;

    public static synchronized KweetDao getKweetDao() {
        if (instance == null) {
            instance = new KweetDaoImp();
        }
        return instance;
    }

    private KweetDaoImp() {
        this.initWebBlog();
    }

    public void initWebBlog() {
        kweets = new ConcurrentHashMap<>();
    }


    @Override
    public Kweet create(Kweet kweet) {
        if (kweet == null) {
            throw new IllegalArgumentException("Kweet is null");
        }

        kweets.put(kweet.getKweetId(), kweet);
        return kweet;
    }

    @Override
    public Kweet update(long kweetId, String ownerId, String kweet, Date postDate) {
        if (ownerId == null || kweet == null) {
            throw new IllegalArgumentException("Owner or kweet is null");
        }
        if (!kweets.containsKey(kweetId)) {
            throw new IllegalArgumentException("KweetId not found: " + kweetId);
        }

        Kweet k = kweets.get(kweetId);
        k.setKweet(kweet);
        k.setPostDate(postDate);

        return k;
    }

    @Override
    public void delete(long kweetId) {
        if (!kweets.containsKey(kweetId)) {
            throw new IllegalArgumentException("Id not found: " + kweetId);
        }

        kweets.remove(kweetId);
    }

    @Override
    public List<Kweet> findAll() {
        return new ArrayList(kweets.values());
    }

    @Override
    public Kweet find(Long id) {
        if (!kweets.containsKey(id)) {
            throw new IllegalArgumentException("Id not found: " + id);
        }
        return kweets.get(id);
    }
}
