package Dao;
import Model.Kweet;

import java.util.Date;

public interface KweetDao {

    Kweet create(Kweet kweet);

    Kweet update(long kweetId, String ownerId, String kweet, Date postDate);

    void delete(long kweetId);
}
