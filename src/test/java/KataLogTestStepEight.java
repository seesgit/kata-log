import exceptions.FormatIncorrectException;
import exceptions.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataLogTestStepEight {

    @Test
    void testStepEight() throws FormatIncorrectException, NegativeNumberException{
        CalculatorKata calculatorKata = new CalculatorKata();
        int add = calculatorKata.add("//[*][%]\n1*2%3");

        assertEquals(6,add);
    }

}
