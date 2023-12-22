import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // ?: wildcard
        BiFunction<Function<Integer, ?>, Integer, ?> callable = (fn, x) -> fn.apply(x * x);
        System.out.println(callable.apply(x -> x + 30, 10));  // 130
        System.out.println(callable.apply(p -> "x is " + p, 5));
        Function<Integer, Double> toDouble = num -> num + 0.0;
        System.out.println(callable.apply(toDouble, 2));

        BiConsumer<Consumer<Integer>, Integer> callable2 = (f, x) -> f.accept(x);
        Consumer<Integer> callableP = p -> System.out.println("p is " + p);
        callable2.accept(callableP, 10);
    }
}
