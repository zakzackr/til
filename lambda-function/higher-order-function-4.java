import java.util.function.*;

public class Main {
    public static int summation(Function<Integer, Integer> fn, int a, int b){
        if (b < a) return 0;
        return fn.apply(b) + summation(fn, a, b - 1);
    }

    public static int summation(Supplier<Integer> fn, int a, int b){
        if (b < a) return 0;
        return fn.get() + summation(fn, a, b - 1);
    }

    public static int pPi(Function<Integer, Integer> fn, int a, int b){
        if (b < a) return 1;
        return fn.apply(b) * pPi(fn, a, b - 1);
    }

    public static long pPi(Function<Long, Long> fn, long a, long b){
        if (b < a) return 1;
        return fn.apply(b) * pPi(fn, a, b - 1);
    }

    public static int pPi(Supplier<Integer> fn, int a, int b){
        if (b < a) return 1;
        return fn.get() * pPi(fn, a, b - 1);
    }

    public static void main(String[] args) {
        Function<Integer, Integer> squaredX = n -> n * n;
        System.out.println(summation(squaredX, 1, 25));  // 5525

        Function<Integer, Integer> calcFn = x -> 3 * x * (x + 3);
        System.out.println(summation(calcFn, 1, 10));  // 1650

        Function<Integer, Integer> calcFn2 = x -> 2 * x * (x - 1);
        int m = 20;
        System.out.println(summation(calcFn2, 1, m));  // 5320

        Function<Integer, Integer> calcFn3 = k -> 7 - k;
        System.out.println(pPi(calcFn3, 1, 6));  // 720

        Function<Long, Long> calcFn4 = x -> x * x + 3;
        System.out.println(pPi(calcFn4, 3, 9));  // 72864320256
    }
}
