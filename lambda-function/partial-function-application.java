// 部分適用:複数の引数を取る関数のうち、一部の引数をデフォルト値に固定し、より少ない引数を取る新しい関数を作成すること

import java.util.function.Function;

public class Main {
    public static double usdToJpy(double USDJPY, double paymentUSD, double handlingCharge) {
        return USDJPY * paymentUSD + handlingCharge;
    }

    public static void main(String[] args) {
        // レート(USDJPY), 手数料（handlingCharge）は毎回同じなのに、毎回記述するのは冗長
        System.out.println(usdToJpy(140.25, 200, 3000));
        System.out.println(usdToJpy(140.25, 1000, 3000));

        // 部分適用を使用する
        // 関数の部分適用は、ラムダ出力で実現できる
        // 部分適用とは、複数の引数を取る関数（usdToJpy）のうち、一部の引数（USDJPY, handlingCharge）をデフォルト値に固定し、
        // より少ない引数を取る新しい関数（usdTojpyVisaNov17th）を作成すること
        Function<Double, Double> usdTojpyVisaNov17th = paymentUSD -> usdToJpy(140.25, paymentUSD, 3000);
        System.out.println(usdTojpyVisaNov17th.apply(200d));
        System.out.println(usdTojpyVisaNov17th.apply(1000d));

        // カリー化使用してさらに簡潔に記述してみる
        // 三つの引数をとるusdToJpyを一つの引数をとる複数の関数に分解
        Function<Double, Function<Double, Function<Double, Double>>> usdTojpyCarry = USDJPY -> handlingCharge -> paymentUSD -> {
            return USDJPY * paymentUSD + handlingCharge;
        };

        // カリー化の後に部分適用して、新たな関数(usdTojpyVisaNov17thCarry)を作成
        Function<Double, Double> usdTojpyVisaNov17thCarry = usdTojpyCarry.apply(140.25).apply(3000d);
        System.out.println(usdTojpyVisaNov17thCarry.apply(200d));
        System.out.println(usdTojpyVisaNov17thCarry.apply(1000d));
    }
}
