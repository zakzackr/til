## Anonymous Class(匿名クラス）
### 匿名クラスを使用しない場合
一般的なインターフェースの定義とその実装クラスの実装を行なっています。このように定義することで、他の場所（他クラス内など）での関数の再利用が可能になります。
```
interface RandomCalc{
    public int add(int x);  // 抽象クラス
}

class RandomCalcImpl implements RandomCalc{  // 実装クラスで抽象クラスの実装を提供
    public int add(int x){
        return x + 1;
    }
}

public class Demo1 {
    public static void main(String[] args){
        RandomCalc random = new RandomCalcImpl();
        System.out.println(random.add(1));  // 2
        System.out.println(new RandomCalcImpl().add(2));  // 3
    }
}
```

### 抽象クラスを使用する場合-1



### 匿名クラスのルール
抽象メソッド一つだけ。

