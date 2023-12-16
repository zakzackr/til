import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

class Assertion{
    public static void run(boolean b) throws Exception{
        if (!b) throw new Exception("Assertion Error...");
    }
}

class Main{
    public static void main(String[] args) throws Exception{
        String[] emails = {"aaa@gmail.com", "abab@gmail.com", "aaa@gmail.com", "ccc@gmail.com"};

        BiPredicate<String[], String[]> hasSameElements = (a, b) -> {
            Map<String, Integer> aHash = new HashMap<>();
            Map<String, Integer> bHash = new HashMap<>();

            for (String i: aHash.keySet()) aHash.put(i, 1);
            for (String i: aHash.keySet()) aHash.put(i, 1);

            for (String str: aHash.keySet()){
                if (!bHash.containsKey(str)) return false;
            }

            return true;
        };

        String[] uniqueArr = createSetList(emails);
        System.out.println(equalAssertion(emails, uniqueArr, hasSameElements));

        // using Stream API
        String[] emails2 = {"abc@gmail.com", "abab@gmail.com", "abc@gmail.com", "abab@gmail.com"};
        // Stream.distinct(): finding the distinct elements by field from a Stream
        List<String> list = Arrays.stream(emails2).distinct().collect(Collectors.toList());
        // The toArray() method of List interface returns an array containing all the elements present in the list in proper order.
        String[] uArr = list.toArray(new String[list.size()]);
        System.out.println(equalAssertion(emails2, uArr, hasSameElements));
    }

    public static String[] createSetList(String[] emails){
        Map<String, String> hashmap = new HashMap<>();
        for (String str: emails){
            if (!hashmap.containsKey(str)) hashmap.put(str, str);
        }

        String[] output = hashmap.keySet().toArray(new String[hashmap.size()]);
        return output;
    }

    public static boolean equalAssertion(String[] a, String[] b, BiPredicate<String[], String[]> callback) throws Exception{
        boolean equality = callback.test(a, b);
        Assertion.run(equality);
        return true;
    }
}

