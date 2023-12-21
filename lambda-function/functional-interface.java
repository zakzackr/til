import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // java.util.function.Supplier
        // @FunctionalInterface
        // public interface Supplier<T>
        Supplier<String> lambda1 = () -> "Hello World!!";
        Supplier<Integer> lambda2 = () -> 4 + 5;
        System.out.println(lambda1.get());  // Hello World!!
        System.out.println(lambda2.get());  // 9

        //ラムダ式スコープ外の変数にアクセスしてみる
        int p = 4;
        Supplier<Integer> lambda3 = () -> p + 5;
        System.out.println(lambda3.get());  // 9

        // java.util.function.Function
        // @FunctionalInterface
        // public interface Function<T,R>
        Function<Integer, Integer> lambda4 = x -> x * x;
        System.out.println(lambda4.apply(5));

        // applyメソッドを匿名クラスを使って実装する
        Function<Integer, Integer> anonym = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + p;
            }
        };
        System.out.println(anonym.apply(5));
    }
}
