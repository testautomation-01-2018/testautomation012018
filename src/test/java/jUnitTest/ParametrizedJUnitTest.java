package jUnitTest;

import com.jsystems.PhoneValidator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(JUnitParamsRunner.class)
public class ParametrizedJUnitTest {

    private PhoneValidator phoneValidator;



    @Test
    @Parameters({"1234567890", "123-456-7890","123.456.7890",
            "123 456 7890", "123-456-7890 ext1234"})
    public void checkIfPhoneCorrect(String phoneNumber){
        assertTrue(phoneValidator.validatePhoneNumber(phoneNumber));
    }

         @Test
    @Parameters({"123456sadf7890", "12sadf3-456-7890","123..456.7890",
            "123__456 7890", "123--456-7890 extasdads1234"})
            public void checkIfPhoneInCorrect(String phoneNumber){
        assertFalse(phoneValidator.validatePhoneNumber(phoneNumber));
    }

    @Test
    @Parameters({"lll@de.do", "sdfsdf.sdf.sdf"})
                public void checkIfEmailValid(String email){
        assertTrue(phoneValidator.isValidEmail(email));
    }


}
