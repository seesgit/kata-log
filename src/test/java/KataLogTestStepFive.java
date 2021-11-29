import exceptions.FormatIncorrectException;
import exceptions.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KataLogTestStepFive {

    @Test
    void testStepFiveNegativeNumbers() throws FormatIncorrectException, NegativeNumberException {
        CalculatorKata calculatorKata = new CalculatorKata();

        NegativeNumberException negativeNumberException = assertThrows(NegativeNumberException.class, () -> calculatorKata.add("//:\n1:-2,2"));

        assertEquals("negatives not allowed : -2",negativeNumberException.getMessage());
    }

    @Test
    void testStepFiveMultiplesNegativeNumbers() throws FormatIncorrectException, NegativeNumberException {
        CalculatorKata calculatorKata = new CalculatorKata();
        int add = calculatorKata.add("//:\n1:2,2");

        NegativeNumberException negativeNumberException = assertThrows(NegativeNumberException.class, () -> calculatorKata.add("//:\n1:-2,-22"));

        assertEquals("negatives not allowed : -2,-22",negativeNumberException.getMessage());
    }

}
