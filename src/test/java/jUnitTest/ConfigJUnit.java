package jUnitTest;

import org.junit.Before;
import org.junit.BeforeClass;

public class ConfigJUnit {

    @Before
    public void setUp(){
        System.out.println("======= @Before jUnitTest.FirstJUnitTest  ========");
    }

    @BeforeClass
    public static void init(){
        System.out.println("======= @BeforeClass SecondJUnitTest  ========");

    }

}
