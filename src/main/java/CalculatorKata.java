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
        if(numbers.startsWith("//[")){


            String specificDelimiter = numbers.substring(3,numbers.indexOf("]"));
            char[] chars = specificDelimiter.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (char aChar : chars) {
                if (isSpecificCharacter(aChar)) {
                    stringBuilder.append("\\").append(aChar);
                } else {
                    stringBuilder.append(aChar);
                }
            }
            delimiter = delimiter.concat("|"+ stringBuilder);
            numbers = numbers.substring(numbers.indexOf("]")+1);

        } else if(numbers.startsWith("//")){

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

    private boolean isSpecificCharacter(char c) {
        // . ^ $ * + - ? ( ) [ ] { } \ | — /
        return c == '.' || c == '^' || c == '$' || c == '*'
                || c == '+' || c == '-' || c == '?' || c == '('
                || c == ')' || c == '[' || c == ']' || c == '{'
                || c == '}' || c == '\\' || c == '|' || c == '—'
                || c=='/';
    }
}
