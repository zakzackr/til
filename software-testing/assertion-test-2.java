import java.util.function.BiPredicate;
import java.util.function.Predicate;

class Assertion{
    public static void run(boolean b) throws Exception{
        if (!b) throw new Exception("Assertion Error...");
    }
}

class Main{
    public static void main(String[] args){
        BiPredicate<Integer, Predicate<Integer>> assertionTest = (num, callback) -> {
            boolean isSquared = callback.test(num);
            try{
                Assertion.run(isSquared);
            } catch (Exception e){
                System.out.println(e);
            }

            return isSquared;
        };

        Predicate<Integer> isSquaredNum = num -> {
            return Math.sqrt(num) % 1 == 0;
        };

        assertionTest.test(100, isSquaredNum);
//        assertionTest.test(77, isSquaredNum);  // an assertion error
    }
}
