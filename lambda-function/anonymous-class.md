## Anonymous Class(匿名クラス）
### 匿名クラスを使用しない場合
一般的なインターフェースの定義とその実装クラスの実装を行なっています。このように定義することで、他の場所（他クラス内など）での関数の再利用が可能になります。
```
interface Example{
    public void display();  // 抽象クラス
}

class ExampleImpl implements Example{  // 実装クラスで抽象メソッドの実装を提供
    public void display(){
        System.out.println("Hello World!");
    }
}

public class Demo1 {
    public static void main(String[] args){
        Example example = new ExampleImpl();
        example.display();  // Hello World!
        new ExampleImpl().display();  // Hello World!
    }
}
```

### 抽象クラスを使用する場合
このようにクラス・関数を再利用することを想定していない場合、その場で定義し利用することができます。
```
@FunctionalInterface // 関数型インターフェースであることを宣言。省略可能。
interface Example{
    public void display();
}

public class Demo2 {
    public static void main(String[] args){
        // インターフェースを実装する匿名クラス
        // 抽象クラスのインスタンスをexample変数に格納
        Example example = new Example(){
            // 抽象メソッドの実装を提供
            @Override
            public void display() {
                System.out.println("Hello World!");
            }
        };

        example.display();  // その場でメソッドの実行
    }
}
```
また、抽象クラスのインスタンスを変数に格納せずに、以下のようにメソッドを実行することも可能です。
```
@FunctionalInterface // 関数型インターフェースであることを宣言。省略可能。
interface Example{
    public void display();
}

public class Demo2 {
    public static void main(String[] args){
        // 変数に格納しない
        new Example(){ 
            // 抽象メソッドの実装を提供
            @Override
            public void display() {
                System.out.println("Hello World!");
            }
        }.display();
    }
}
```
### 匿名クラスの定義をラムダ式で行う
ラムダ式を使用することで、匿名クラスの実装を簡潔に記述できます。
```
interface Example{
    public void display();
}

public class Demo2 {
    public static void main(String[] args){
        // ラムダ式を使用する
        Example example = () -> System.out.println("Hello World!");
        example.display();  // Hello Wolrd!!
    }
}
```


