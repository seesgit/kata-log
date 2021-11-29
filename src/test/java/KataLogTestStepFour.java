import exceptions.FormatIncorrectException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataLogTestStepFour {

    @Test
    void testStepFourWithNewLine() throws FormatIncorrectException {
        CalculatorKata calculatorKata = new CalculatorKata();
        int add = calculatorKata.add("//:\n1:2,2");

        assertEquals(5,add);
    }

    @Test
    void testStepFourWithIncorrectDelimiter() throws FormatIncorrectException{
        CalculatorKata calculatorKata = new CalculatorKata();
        int add = calculatorKata.add("//:\n1::2,2");

        assertEquals(5,add);
    }

}
