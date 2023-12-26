Javaではラムダの中からラムダ外の変数にアクセスする場合finalである必要がある。

``` java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int counter = 0;

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int[] arr = new int[]{0};

        list.forEach(x -> {
            System.out.println(counter);  // ラムダ関数外の変数を見ることはできる
//            counter++;  // ラムダ関数外の変数を変更することはできない。finalであれば変更可能
            arr[0]++;  // アクセス先が配列など参照の場合は変更できる
        });

        System.out.println(arr[0]);
    }
}
```
