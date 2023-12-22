import java.util.function.*;

public class Main {
    // 匿名クラスを使用して、呼び出し可能オブジェクトを出力として返す
    public static Runnable createPrintFn(String str){
        return new Runnable(){
            @Override
            public void run(){
                System.out.println(str);
            }
        };
    }

    public static void repeat(int times, Runnable fn){
        for (int i = 0; i < times; i++){
            fn.run();
        }
    }

    public static void main(String[] args) {
        Runnable callableFn = createPrintFn("Hello World");
        System.out.println(callableFn);  // 参照を返す
        callableFn.run();  // Hello World
        repeat(4, callableFn);

        // Javaの関数型インターフェースを使用する
        Function<String, Runnable> lambda = str -> () -> System.out.println(str);
        lambda.apply("Hello World2").run();

        BiConsumer<Integer, Function<String, Runnable>> lambda2 = (times, fn) -> {
            for (int i = 0; i < times; i++){
                fn.apply("Hello World3").run();
            }
        };

        lambda2.accept(4, lambda);
    }
}
