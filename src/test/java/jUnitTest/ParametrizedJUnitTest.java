package jUnitTest;

import com.jsystems.PhoneValidator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.custom.combined.CombinedParameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(JUnitParamsRunner.class)
public class ParametrizedJUnitTest extends ConfigJUnit {

//    public PhoneValidator phoneValidator;



    @Test
    @Parameters({"1234567890", "123-456-7890","123.456.7890",
            "123 456 7890", "123-456-7890 ext1234"})
    public void checkIfPhoneCorrect(String phoneNumber){
        assertTrue(PhoneValidator.validatePhoneNumber(phoneNumber));
    }

         @Test
    @Parameters({"123456sadf7890", "12sadf3-456-7890","123..456.7890",
            "123__456 7890", "123--456-7890 extasdads1234"})
            public void checkIfPhoneInCorrect(String phoneNumber){
        assertFalse(PhoneValidator.validatePhoneNumber(phoneNumber));
    }

    @Test
    @Parameters({"lll@de.do", "sdfsdf@sdf.sdf"})
                public void checkIfEmailValid(String email){
        assertTrue(PhoneValidator.isValidEmail(email));
    }

    @Test
    @CombinedParameters({"1,3", "2,4"})
    public void combinedParam(String first, String second){
        String result = first + second;

        System.out.println(first + " , " + second);

        assertTrue(result.contains("1") || result.contains("3"));
        assertTrue(result.contains("2") || result.contains("4"));
    }
}
