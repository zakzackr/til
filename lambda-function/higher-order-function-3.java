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

    public static int pPi(Supplier<Integer> fn, int a, int b){
        if (b < a) return 1;
        return fn.get() * pPi(fn, a, b - 1);
    }

    public static void main(String[] args) {
        // 1-10までの総和
        Function<Integer, Integer> fn = num -> num;
        System.out.println(summation(fn, 1, 10));  // 55

        // 10 * 100
        Supplier<Integer> fn2 = () -> 10;
        System.out.println(summation(fn2, 1, 100));

        // 10の階乗
        System.out.println(pPi(fn , 1, 10));

        // 5^10
        Supplier<Integer> fn3 = () -> 5;
        System.out.println(pPi(fn3, 1, 10));
    }
}
