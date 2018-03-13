package Dao;
import Model.Kweet;

import java.util.Date;
import java.util.List;

public interface KweetDao {

    Kweet create(Kweet kweet);

    Kweet update(Kweet kweet);

    boolean delete(Long id);

    List<Kweet> findAll();

    //Kweet find(Long id);
}
