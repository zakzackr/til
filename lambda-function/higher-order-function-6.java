// 呼び出し可能オブジェクトの保存と別の関数への引き渡し

import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Supplier<Supplier<String>> helloWorldFunc = () -> () -> "Hello World";
        System.out.println(helloWorldFunc.get());  // 関数を返す
        System.out.println(helloWorldFunc.get().get());  // Hello Worldを返す

        // 呼び出し可能オブジェクトの保存
        Supplier<String> outputF = helloWorldFunc.get();
        System.out.println(outputF.get());  // Hello Worldを返す
    }
}
