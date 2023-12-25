import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> multiplier = x -> y -> x * y;
        Function<Integer, Integer> multiplyBy4 = x -> 4 * x;

        System.out.println(multiplier.apply(3).apply(4));
        System.out.println(multiplyBy4.apply(3));
    }
}
