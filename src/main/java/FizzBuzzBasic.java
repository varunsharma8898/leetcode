import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FizzBuzzBasic {

    public List<String> fizzBuzz(int n) {

        List<String> res = new ArrayList<>();
        int counter = 1;
        while (counter <= n) {
            if (counter % 3 == 0 && counter % 5 != 0) {
                res.add("Fizz");
            } else if (counter % 3 != 0 && counter % 5 == 0) {
                res.add("Buzz");
            } else if (counter % 3 == 0 && counter % 5 == 0) {
                res.add("FizzBuzz");
            } else {
                res.add(counter + "");
            }
            counter++;
        }
        return res;
    }

    public static void main(String[] args) {
        FizzBuzzBasic obj = new FizzBuzzBasic();
        List<String> res = obj.fizzBuzz(15);
        System.out.println(res.stream().collect(Collectors.joining(", ")));
    }
}
