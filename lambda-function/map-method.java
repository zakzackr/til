import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        list.stream()
                .map(x -> x * x)  // 中間操作
                .forEach(System.out::println);  // 終端操作

        Function<Integer, Integer> squareX = x -> x * x;

        list.stream()
                .map(squareX)
                .forEach(System.out::println);
    }
}
