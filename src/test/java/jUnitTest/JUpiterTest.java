package jUnitTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static junit.framework.TestCase.assertTrue;

@DisplayName("===== sdfsdfsdfsdfsdfsdf =======")
public class JUpiterTest extends ConfigJupiter {


        @Nested
        @DisplayName("=========== jupiter nested klas=====")
        public class JupiterParameterized {


            int testowy = 20;
            String testowyString = "Ala ma kota";

            @Test
            @DisplayName("== to jest test jupitera =====")
            @RepeatedTest(5)
            public void jupiterTest() {
                System.out.println("jupiter");
                assertTrue(testowy == 20);
            }

        }

        @Nested
        @DisplayName("=========== jupiter nested next klas=====")
        public class JupiterParameterizedTest {


            int testowy = 20;
            String testowyString = "Ala ma kota";

            @Test
            @DisplayName("== to jest test jupitera =====")
            @RepeatedTest(5)
            public void jupiterNextTest() {
                System.out.println("jupiter");
                assertTrue(testowy == 20);
            }
        }

        @Nested
        @DisplayName("===== jupiter nested text ")
        public class nextNestedTest{

            @Test
            @DisplayName("== to jest test jupitera =====")
            @RepeatedTest(2)
            public void jupiterNext2Test() {
                System.out.println("jupiter");
                assertTrue(5*4 == 20);
            }

            @ParameterizedTest
            @DisplayName("Test z CSV")
            @CsvFileSource(resources = "/plik.csv")
            public void csvTest(String name, int age){
                assertTrue(name instanceof String);
//                assertTrue(age instanceof Integer);
                assertTrue(age < 1000);
            }

            @ParameterizedTest
            @ValueSource(ints = {1,2,3,4})
            public void withValueSourceTest(int value){
                assertTrue(value < 100);
            }

        }
}
