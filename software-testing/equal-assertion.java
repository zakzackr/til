import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;

class Assertion{
    public static void run(boolean b) throws Exception{
        if (!b) throw new Exception("Assertion Error...");
    }
}

class Main{
    public static void main(String[] args) throws Exception{
        int[] arr1 = new int[]{3,4,5,10,2,8,12};
        int[] arr2 = new int[]{4,5,3,12,10,8,2};
        int[] arr3 = new int[]{4,5,3,12,10,8,2};

        BiPredicate<int[], int[]> orderedArrayEquality = (a, b) -> {
            if (a.length != b.length) return false;
            for (int i = 0; i < a.length; i++){
                if (a[i] != b[i]) return false;
            }

            return true;
        };

        BiPredicate<int[], int[]> unorderedArrayEquality = (a, b) -> {
            if (a.length != b.length) return false;
            Map<Integer, Integer> aHash = new HashMap<>();
            Map<Integer, Integer> bHash = new HashMap<>();

            for (int i = 0; i < a.length; i++){
                aHash.put(a[i], aHash.getOrDefault(a[i], 0) + 1);
                bHash.put(b[i], bHash.getOrDefault(b[i], 0) + 1);
            }

            for (Integer key: aHash.keySet()){
                if (!bHash.containsKey(key)) return false;
                if (aHash.get(key) != bHash.get(key)) return false;
            }

            return true;
        };

        // test
//        System.out.println(equalAssertion(arr1, arr2, orderedArrayEquality));  // Assertion Error...
        System.out.println(equalAssertion(arr2, arr3, orderedArrayEquality));  // pass
        System.out.println(equalAssertion(arr1, arr2, unorderedArrayEquality));  // pass

    }

    public static boolean equalAssertion(int a, int b) throws Exception{
        boolean equality = (a == b);
        Assertion.run(equality);
        return true;
    }

    public static boolean equalAssertion(int[] a, int[] b, BiPredicate<int[], int[]> callback) throws Exception{
        boolean equality = callback.test(a, b);
        Assertion.run(equality);
        return true;
    }
}

