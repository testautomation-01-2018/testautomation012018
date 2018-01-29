package jUnitTest;

import com.jsystems.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class FirstJUnitTest extends ConfigJUnit {


    //ahefkasjdf awewfafsd sadfasdfllkjasd  sadfaklj
    /*
    * to jest
    * komentarz
    * do testu
    * */

    @Before
    public void setUp(){
        System.out.println("===== To jest nasze do testu tylko FirstJUnitTest =");
    }


    public int testowaLiczba = 2;

    public String testowy = "testowy";
    public String testowy2 = "to jest nasz tekst testowy";

    public int naszValue = 15;

    @Test
    public void firstTest(){
        assertTrue(testowaLiczba == (1+1));
        assertTrue(testowy.equals("testowy"));
        assertFalse(testowy.equals("test"));
        assertThat("to jest test na that", testowy, is("testowy"));
        assertTrue(naszValue == 15);
        assertThat(testowy2, containsString("testowy"));
        assertThat(testowy2.toLowerCase(), endsWith("y"));
    }

    @Test
    public void drugiTest(){
        Integer wartoscTestowa = null;
        assertNull(wartoscTestowa);
        assertNull(wartoscTestowa);
    }

    List<Integer> integery = Arrays.asList(1,2,3,4,5,6);
    List<Integer> integery2 = Arrays.asList(1,2,3,4,5,6);

    @Test
    public void trzeciTest() {
        assertThat(integery, hasItem(5));
        assertThat(integery, hasSize(6));
        assertArrayEquals(integery.toArray(), integery2.toArray());
    }

    String ala = "ala";

    String beta2 = "ala";
    String ala2 = new String("ala");
    String beta = ala2;
    int dwoja;
    Integer dwoja2 = new Integer(2);
    Integer dwoja3;
    @Test
            public void czwartyTest(){

    assertTrue(ala == beta2);
//    assertTrue(ala.equals(ala2));
    assertTrue(beta.equals(ala2));
    assertNull(dwoja3);

    }

    User naszUser = new User();


    @Test
    public void piatyTest(){
        assertTrue(naszUser.countAge(20) == 120);
        assertFalse(naszUser.countAge(15) == 120);
    }

}
