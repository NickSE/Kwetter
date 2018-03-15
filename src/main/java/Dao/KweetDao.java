package Dao;
import Model.Kweet;

import java.util.Date;
import java.util.List;

public interface KweetDao {

    Kweet create(Kweet kweet);

    void update(Kweet kweet);

    void delete(Kweet kweet);

    List<Kweet> findAll();

    //Kweet find(Long id);
}
