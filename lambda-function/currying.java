// カリー化：複数の引数を取る関数を、それぞれ単一の引数を取る一連の関数に変換する手法

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // 引数を二つ持つラムダ
        BiFunction<Integer, Integer, Integer> addFn = (x, y) -> x + y;

        // カリー化
        // 引数を一つ持つ二つのラムダを使用してカリー化
        Function<Integer, Function<Integer, Integer>> addCurry = x -> y -> x + y;

        System.out.println(addFn.apply(2, 3));  // 5
        System.out.println(addCurry.apply(2).apply(3));  // 5
    }
}
