// In this example, variables (firstName/lastName) are defined in 3 different scopes

public class Main{

    public static String firstName = "Masamune";
    public static String lastName = "Watanabe";

    public static String userName(){
        // defining variables that belong to this method(local scope)
        String firstName = "Emily";
        String lastName = "Robertson";

        return firstName + " - " + lastName;
    }

    public static void main(String[] args){
        // There are no variables named as firstName/lastName, so this program will look for firstName/lastName in static context
        System.out.println(firstName + " - " + lastName);  // -> Masamune - Watanabe

        // defining firstName/lastName in the scope of the main method(local scope)
        String firstName = "Fernando";
        String lastName = "Yamato";
        // The program will find firstName/lastName in this local scope
        System.out.println(firstName + " - " + lastName);  // -> Fernando - Yamato

        // The firstName/lastName defined inside the userName method will be called
        System.out.println(userName());  // -> Emily - Robertson

        // overriding firstName/lastName in the scope of the main method
        firstName = "Andy";
        lastName = "Jordan";
        System.out.println(firstName + " - " + lastName);  // -> Andy - Jordan
        // The firstName/lastName defined in the static context will be called
        System.out.println(Main.firstName + " - " + Main.lastName);  // -> Masamune - Watanabe
    }
}
