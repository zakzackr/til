## Anonymous Class(匿名クラス）
### 匿名クラスを使用しない場合
一般的なインターフェースの定義とその実装クラスの実装を行なっています。このように定義することで、他の場所（他クラス内など）での関数の再利用が可能になります。
```
interface Example{
    public void print();  // 抽象クラス
}

class ExampleImpl implements Example{  // 実装クラスで抽象メソッドの実装を提供
    public void print(){
        System.out.println("Hello World!");
    }
}

public class Demo1 {
    public static void main(String[] args){
        Example example = new ExampleImpl();　　実装クラスのインスタンスを生成
        example.print();  // Hello World!
        new ExampleImpl().print();  // Hello World!
    }
}
```

### 抽象クラスを使用する場合
このようにクラス・関数を再利用することを想定していない場合、その場で定義し利用することができます。
```
@FunctionalInterface // 関数型インターフェースであることを宣言。省略可能。
interface RandomContainer{
    public void print();
}

public class Demo2 {
    public static void main(String[] args){
        // 匿名クラス
        RandomContainer randomContainer = new RandomContainer() {
            // 抽象クラスの実装を提供
            @Override
            public void print() {
                System.out.println("Hello World!");
            }
        };

        randomContainer.print();
    }
}
```
また



### 匿名クラスのルール
抽象メソッド一つだけ。

