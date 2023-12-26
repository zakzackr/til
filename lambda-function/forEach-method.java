import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list1.forEach(x -> System.out.println(x));
        list1.forEach(System.out::println);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.forEach((key, value) -> System.out.println(key + ":" + value));

        // StreamAPI
        // Arraysクラス stream(arr)
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Arrays.stream(arr).forEach(x -> System.out.println(x));
        IntStream intStream = Arrays.stream(arr);
        intStream.forEach(System.out::println);

        // Collectionインターフェース stream()
        List<String> strList = Arrays.asList("a","b","c","d");
        strList.stream().forEach(System.out:: println);

        // Streamインターフェース of()
        Stream stream = Stream.of("a","b","c","d");
//        stream.forEach(System.out::println);  // unchecked operation
        Stream.of("a","b","c","d").forEach(System.out::println);
    }
}
