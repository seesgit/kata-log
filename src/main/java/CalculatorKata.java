import exceptions.FormatIncorrectException;
import exceptions.NegativeNumberException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CalculatorKata {

    int add(String numbers) throws FormatIncorrectException, NegativeNumberException {

        if(numbers.isEmpty()){
            return 0;
        } else if(numbers.length() ==1){
            return Integer.parseInt(numbers);
        } else if(numbers.contains(",\n")||numbers.contains("\n,")) {
            throw new FormatIncorrectException();
        }

        String delimiter = ",|\\n";
        if(numbers.startsWith("//")){

            delimiter = delimiter.concat("|"+ numbers.charAt(2));
            numbers = numbers.substring(2);
        }

        String[] split = numbers.split(delimiter);

        int[] ints = Arrays.stream(split).filter(s -> !s.isEmpty()).filter(s -> Integer.parseInt(s) < 0).mapToInt(Integer::parseInt).toArray();
        if(ints.length != 0){
            throw new NegativeNumberException("negatives not allowed : "+ Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        }

        return Arrays.stream(split).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).sum();
    }
}
