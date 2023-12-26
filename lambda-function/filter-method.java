import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        list.stream()
                .filter(x -> x % 2 == 0)  // 中間操作
                .forEach(System.out::println);  // 終端操作
    }
}
