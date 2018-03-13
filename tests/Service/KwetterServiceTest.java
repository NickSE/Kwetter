package Service;

import Model.Kweet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class KwetterServiceTest {

    Kweet kweet = new Kweet(123456789,"Nick", "Test", new Date());
    Kweet kweet2 = new Kweet(1234567890, "NickJr", "Test123", new Date());
    KwetterService kwetterService = new KwetterService();

//    @Test
//    public void addKweet() {
//        assertEquals(kwetterService.addKweet(kweet), kweet);
//    }
//
//    @Test
//    public void editKweet(){
//        kwetterService.addKweet(kweet);
//        assertNotEquals(kwetterService.editKweet(123456789,"Nick", "Test123", new Date()), kweet.getKweet());
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void deleteKweet(){
//        long id = 123456789;
//        kwetterService.removeKweet(id);
//        kwetterService.getKweet(id);
//    }

    @Test
    public void getKweets(){
        ArrayList<Kweet> kweets = new ArrayList<Kweet>();
        kweets.add(kweet2);
        kweets.add(kweet);

        kwetterService.addKweet(kweet);
        kwetterService.addKweet(kweet2);

        assertThat(kwetterService.getKweets(), is(kweets));
    }
}