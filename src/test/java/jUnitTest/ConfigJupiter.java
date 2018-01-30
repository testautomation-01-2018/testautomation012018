package jUnitTest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ConfigJupiter {

    @BeforeEach
    public void setUp(){
        System.out.println("======= @BeforeEach jUnitTest.FirstJUnitTest  ========");
    }

    @BeforeAll
    public static void init(){
        System.out.println("======= @BeforeAll SecondJUnitTest  ========");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("======= @AfterEach jUnitTest.FirstJUnitTest  ========");

    }

    @AfterAll
    public static void closeAll(){
        System.out.println("======= @AfterAll jUnitTest.FirstJUnitTest  ========");

    }
}
