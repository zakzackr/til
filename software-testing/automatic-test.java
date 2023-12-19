// 自動テストを行う際にも、特定の分野での知識や情報が必要となる。今回のケースでは、kとnなどの情報が必要となる。

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

class Assertion{
    public static void run(boolean b) throws Exception{
        if (!b) throw new Exception("Assertion Error...");
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        BiPredicate<ArrayList<Integer>, Predicate<ArrayList<Integer>>> assertionTest = (a, callback) -> {
            boolean result = callback.test(a);
            try {
                Assertion.run(result);
            } catch (Exception e) {
                System.out.println(e);
            }

            return true;
        };

        //// テストしたい関数
        Function<Integer, ArrayList<Integer>> sieveOfPrimes = n -> {
            boolean[] cache = new boolean[n];
            Arrays.fill(cache, true);

            for (int i = 2; i * i <= n; i++) {
                if (!cache[i]) continue;
                int j = 2;

                while (i * j < n) {
                    cache[i * j] = false;
                    j++;
                }
            }

            ArrayList<Integer> primeList = new ArrayList<>();

            for (int i = 2; i < cache.length; i++) {
                if (cache[i]) primeList.add(i);
            }

            return primeList;
        };

        System.out.println(sieveOfPrimes.apply(10));

        // k: n以下の素数の個数
        BiFunction<Integer, Integer, Predicate<ArrayList<Integer>>> primeCheck = (k, n) -> {
            // n以下の素数を持つリストを作成する
            Predicate<Integer> isPrime = num -> {
                for (int i = 2; i * i <= num; i++){
                    if (num % 2 == 0) return false;
                }

                return num > 1;
            };

            // クロージャ関数
            // primeListを受け取って、リストがn未満の素数をk個含むか判定する関数
            Predicate<ArrayList<Integer>> script = primeList -> {
                if (primeList.size() != k) return false;
                HashSet<Integer> set = new HashSet<>();
                set.addAll(primeList);
                if (k != set.size()) return false;
                for (int i: primeList){
                    if (i > n || !isPrime.test(i)) return false;
                }

                return true;
            };

            return script;
        };

        // test
        assertionTest.test(sieveOfPrimes.apply(10), primeCheck.apply(4, 10));  // pass
        assertionTest.test(sieveOfPrimes.apply(20), primeCheck.apply(8, 20));  // pass
        assertionTest.test(sieveOfPrimes.apply(15),primeCheck.apply(6, 15));  // pass
        assertionTest.test(sieveOfPrimes.apply(100),primeCheck.apply(25, 100));  // pass
        assertionTest.test(sieveOfPrimes.apply(10000),primeCheck.apply(1229, 10000));  // pass
        assertionTest.test(new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 9, 10)), primeCheck.apply(6, 11));  // fail
        assertionTest.test(new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7)), primeCheck.apply(4, 11));  // pass
    }
}
