import java.util.function.BiPredicate;
import java.util.function.Predicate;

class Assertion{
    public static void run(boolean b) throws Exception{
        if (!b) throw new Exception("Assertion Error...");
    }
}

class Main{
    public static void main(String[] args) throws Exception{
        BiPredicate<String, Predicate<String>> assertionTest = (email, callback) -> {
            boolean isValid = callback.test(email);
            try{
                Assertion.run(isValid);
            } catch (Exception e){
                System.out.println(e);
            }

            return true;
        };

        // emailが有効かテストする述語
        // 有効なemailとは空白のスペースがなく、@を1つ含み、@の後に.が含まれる文字列を指します。
        Predicate<String> isValidEmail = email -> {
            return email.indexOf(" ") == -1 && email.contains("@")
                    && email.substring(email.indexOf("@") + 1).indexOf("@") == -1
                    && email.substring(email.indexOf("@") + 1).indexOf(".") != -1;
        };

        assertionTest.test("johnnyTest@test.com",isValidEmail);
//        assertionTest.test("John Test",isValidEmail); // Error
    }
}
