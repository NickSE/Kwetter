package Dao;

import Model.Kweet;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

//@Stateless
public class KweetDaoImp implements KweetDao{

    @PersistenceContext(unitName = "kweetPU")
    private EntityManager em;

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
        kweets.put(nextId.getAndIncrement(), new Kweet(nextId.getAndIncrement(), "Nick", "Test", new Date()));
    }


    @Override
    public Kweet create(Kweet kweet) {
        if (kweet == null) {
            throw new IllegalArgumentException("Kweet is null");
        }

        kweets.put(kweet.getKweetId(), kweet);
        return kweet;
//        em.persist(kweet);
//        return kweet;
    }

    @Override
    public void update(Kweet kweet) {
//        if (ownerId == null || kweet == null) {
//            throw new IllegalArgumentException("Owner or kweet is null");
//        }
//        if (!kweets.containsKey(kweetId)) {
//            throw new IllegalArgumentException("KweetId not found: " + kweetId);
//        }
//
//        Kweet k = kweets.get(kweetId);
//        k.setKweet(kweet);
//        k.setPostDate(postDate);
//
//        return k;
        em.merge(kweet);
    }

    @Override
    public void delete(Kweet kweet) {
//        if (!kweets.containsKey(kweetId)) {
//            throw new IllegalArgumentException("Id not found: " + kweetId);
//        }
//
//        kweets.remove(kweetId);
        em.remove(em.merge(kweet));
    }

    @Override
    public List<Kweet> findAll() {
        return new ArrayList(kweets.values());
//        Query query = em.createQuery("SELECT k FROM Kweet k");
//        return new ArrayList<>(query.getResultList());
    }

//    @Override
//    public Kweet find(Long id) {
//        if (!kweets.containsKey(id)) {
//            throw new IllegalArgumentException("Id not found: " + id);
//        }
//        return kweets.get(id);
//    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
