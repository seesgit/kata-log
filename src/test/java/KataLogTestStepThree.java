import exceptions.FormatIncorrectException;
import exceptions.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KataLogTestStepThree {

    @Test
    void testStepThreeWithNewLine() throws FormatIncorrectException, NegativeNumberException {
        CalculatorKata calculatorKata = new CalculatorKata();
        int add = calculatorKata.add("1\n2,2");

        assertEquals(5,add);
    }

    @Test
    void testStepThreeWithIncorrectFormat() throws FormatIncorrectException, NegativeNumberException{
        CalculatorKata calculatorKata = new CalculatorKata();
        assertThrows(FormatIncorrectException.class,() -> calculatorKata.add("1,2,\n3"));

    }

}
