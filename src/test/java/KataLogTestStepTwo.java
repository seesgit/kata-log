import exceptions.FormatIncorrectException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataLogTestStepTwo {

    @Test
    void testStepTwoMultipleNumbers() throws FormatIncorrectException {
        CalculatorKata calculatorKata = new CalculatorKata();
        int add = calculatorKata.add("1,2,3,4,5");

        assertEquals(15,add);
    }

    @Test
    void testStepTwoMultipleNumbersWithIncorrectNumber() throws FormatIncorrectException{
        CalculatorKata calculatorKata = new CalculatorKata();
        int add = calculatorKata.add("1,2,,,5");

        assertEquals(8,add);
    }

}
