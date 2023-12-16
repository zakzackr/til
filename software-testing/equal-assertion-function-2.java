import java.util.Arrays;
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
        String[] strArr = new String[]{"FIAT", "Mercedes-Benz","CITROËN","BLUEBIRD","Alfa Romeo"};
        String[] copyArr = Arrays.copyOf(strArr, strArr.length);

        BiPredicate<String[], String[]> reversedArrayEquality = (a, b) -> {
            if (a.length != b.length) return false;
            for (int i = 0; i < a.length; i++){
                if (a[i] != b[b.length - i - 1]) return false;
            }

            return true;
        };

        reversedArr(strArr);
        System.out.println(equalAssertion(strArr, copyArr, reversedArrayEquality));
    }

    public static void reversedArr(String[] arr){
        int mid = (arr.length - 1) / 2;
        for (int i = 0; i <= mid; i++){
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static boolean equalAssertion(String[] a, String[] b, BiPredicate<String[], String[]> callback) throws Exception{
        boolean equality = callback.test(a, b);
        Assertion.run(equality);
        return true;
    }
}

