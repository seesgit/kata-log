import java.util.Arrays;

public class CalculatorKata {

    int add(String numbers){

        if(numbers.isEmpty()){
            return 0;
        } else if(numbers.length() ==1){
            return Integer.parseInt(numbers);
        }

        String[] split = numbers.split(",");

        return Arrays.stream(split).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).sum();
    }
}
