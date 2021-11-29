import exceptions.FormatIncorrectException;

import java.util.Arrays;

public class CalculatorKata {

    int add(String numbers) throws FormatIncorrectException {

        if(numbers.isEmpty()){
            return 0;
        } else if(numbers.length() ==1){
            return Integer.parseInt(numbers);
        } else if(numbers.contains(",\n")||numbers.contains("\n,")) {
            throw new FormatIncorrectException();
        }

            String[] split = numbers.split(",|\\n");

        return Arrays.stream(split).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).sum();
    }
}
