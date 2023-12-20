## Anonymous Class(匿名クラス）
### 匿名クラスを使用しない場合
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
