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

        String negativeNumbers = Arrays.stream(split)
                .filter(s -> !s.isEmpty() && Integer.parseInt(s) < 0)
                .mapToInt(Integer::parseInt)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));

        if(!negativeNumbers.isEmpty()){
            throw new NegativeNumberException("negatives not allowed : "+ negativeNumbers);
        }

        return Arrays.stream(split).filter(s -> !s.isEmpty() && Integer.parseInt(s)<=1000).mapToInt(Integer::parseInt).sum();
    }
}
