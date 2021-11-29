import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KataLogTestStepThree {

    @Test
    void testStepThreeWithNewLine(){
        CalculatorKata calculatorKata = new CalculatorKata();
        int add = calculatorKata.add("1\n2,2");

        assertEquals(5,add);
    }

    @Test
    void testStepThreeWithIncorrectFormat() {
        CalculatorKata calculatorKata = new CalculatorKata();
//        int add = calculatorKata.add("1,2,\n3");
        assertThrows(FormatIncorrectException.class,() -> calculatorKata.add("1,2,\n3"));

    }

}
