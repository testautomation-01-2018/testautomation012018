package jUnitTest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.is;
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
        assertThat(testowy2, endsWith("y"));
    }

    @Test
    public void drugiTest(){
        Integer wartoscTestowa = null;
        assertNull(wartoscTestowa);
        assertNull(wartoscTestowa);
    }
}
