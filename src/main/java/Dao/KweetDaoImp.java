package Dao;

import Model.Kweet;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class KweetDaoImp implements KweetDao{

    private static KweetDaoImp instance = null;
    private AtomicLong nextId = new AtomicLong(0L);
    private ConcurrentHashMap<Long, Kweet> kweets;

    public static synchronized KweetDao getPostingDao() {
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

        create(new Kweet(nextId.getAndIncrement(), "Nick", "Test", new Date()));
    }


    @Override
    public Kweet create(Kweet kweet) {
        if (kweet == null) {
            throw new IllegalArgumentException("Kweet is null");
        }

        kweet.setKweetId(nextId.getAndIncrement());
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
}
