// ラムダクロージャ：ラムダ式によって作成された、変数の状態をラムダのスコープにバインドするステートフル関数のこと
// 新しい税率、州、収入を追加する際に、新たな関数を作成する必要がなく、taxLambdaの引数に州名、税率を追加するだけでOK

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        final double federalTax = 0.2;
        BiFunction<String, Double, Function<Integer, Integer>> taxLambda = (state, stateTax) -> {

            Function<Integer, Integer> func = income -> {
                // stateの状態も
                // クロージャはそれが定義されたスコープにある変数（state）を覚えており、そのスコープが消えた後でもそれら変数にアクセスすることができる。
                // func関数が状態を保持する
                System.out.println("applying tax in " + state + " to income " + income);
                // スコープ外のfinalの変数にはアクセス/変更、どちらも可能
                double tax = federalTax + stateTax;
                return (int)(income - income * tax);
            };

            return func;
        };

        Function<Integer, Integer> calTax = taxLambda.apply("California", 0.0725);
        Function<Integer, Integer> texasTax = taxLambda.apply("Texas", 0.0625);
        Function<Integer, Integer> hawaiiTax = taxLambda.apply("Hawaii", 0.04);

        int income = 40000;
        System.out.println(calTax.apply(income));
        System.out.println(texasTax.apply(income));
        System.out.println(hawaiiTax.apply(income));
    }
}
