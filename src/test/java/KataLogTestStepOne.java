import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataLogTestStepOne {

    @Test
    void testStepOneEmptyString(){
        CalculatorKata calculatorKata = new CalculatorKata();
        int add = calculatorKata.add("");

        assertEquals(0,add);
    }

    @Test
    void testStepOneSimpleNumber(){
        CalculatorKata calculatorKata = new CalculatorKata();
        int add = calculatorKata.add("1");

        assertEquals(1,add);
    }

    @Test
    void testStepOneTwoNumber(){
        CalculatorKata calculatorKata = new CalculatorKata();
        int add = calculatorKata.add("1,2");

        assertEquals(3,add);
    }

    @Test
    void testStepOneTwoNumberWithIncorrectValue(){
        CalculatorKata calculatorKata = new CalculatorKata();
        int addOne = calculatorKata.add("1,");
        int addTwo = calculatorKata.add(",1");

        assertEquals(1,addOne);
        assertEquals(1,addTwo);

    }
}
