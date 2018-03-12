package Dao;
import Model.Kweet;

import java.util.Date;
import java.util.List;

public interface KweetDao {

    Kweet create(Kweet kweet);

    Kweet update(long kweetId, String ownerId, String kweet, Date postDate);

    void delete(long kweetId);

    List<Kweet> findAll();

    Kweet find(Long id);
}
