import exceptions.FormatIncorrectException;
import exceptions.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataLogTestStepSix {

    @Test
    void testStepSix() throws FormatIncorrectException, NegativeNumberException{
        CalculatorKata calculatorKata = new CalculatorKata();
        int add = calculatorKata.add("1\n2,1002");

        assertEquals(3,add);
    }

    @Test
    void testStepSixLimit() throws FormatIncorrectException, NegativeNumberException{
        CalculatorKata calculatorKata = new CalculatorKata();
        int add = calculatorKata.add("1\n2,1000");

        assertEquals(1003,add);
    }

}
