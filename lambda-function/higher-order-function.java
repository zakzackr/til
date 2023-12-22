import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        BiFunction<String, Supplier<String>, Supplier<String>> createHighOrderFn = (word, fn) -> () -> fn.get() + word;

        Supplier<String> fn0 = () -> "step0: ";
        // 出力された関数を変数に代入して、そのまま入力に渡すことができる。
        Supplier<String> fn1 = createHighOrderFn.apply("step1: ", fn0);
        Supplier<String> fn2 = createHighOrderFn.apply("step2: ", fn1);

        System.out.println(fn0.get());
        System.out.println(fn1.get());
        System.out.println(fn2.get());
    }
}
