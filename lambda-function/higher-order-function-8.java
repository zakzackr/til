// 言語によっては関数を高階関数の入力として使用することもできるが、Javaでは単純に関数への参照をそのままでは渡すことができない。
// 通常の関数への参照を入力として受け取るには、渡したい関数のスケルトンのみを持つinterfaceを作成し、その実装クラスを定義する必要がある。

import java.util.Random;
import java.util.function.*;

interface Callable{
    public String greetingFn(String name);
}

class Greet implements Callable{
    public String greetingFn(String name){
        return "Hello, " + name;
    }
}

public class Main {
    public static String multiCall(Function<String, String> greetFn, Supplier<String> createName, String message){
        return greetFn.apply(createName.get()) + "..." + message;
    }

    // Callableインターフェースで通常の関数への参照を受け取る関数
    public static String multiCall(Callable f, Supplier<String> createName, String message){
        return f.greetingFn(createName.get()) + "..." + message;
    }

    public static void main(String[] args) {
        Function<String, String> greetingLambda = name -> "Hello, " + name;
        Supplier<String> createNameLambda = () -> {
            String str = "";
            for(int i = 0; i < 10; i++){
                Random r = new Random();
                str += (char)(r.nextInt(26) + 'a');
            }
            return str;
        };

        System.out.println(multiCall(greetingLambda, createNameLambda, "from lambda"));

        // インターフェースのインスタンスを使用して関数への参照を渡す
        Callable g = new Greet();
        System.out.println(multiCall(g, createNameLambda, "from normal function"));
        
        // 匿名クラスを使用
        Callable c = new Callable(){
            public String greetingFn(String name){
                return "I am " + name + ".";
            }
        };
        System.out.println(multiCall(c, createNameLambda, "from normal function"));
    }
}
