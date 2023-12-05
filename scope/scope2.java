// defining A class in the global scope
class A {
    public static int x = 3;
    public static int y = 10;

    // The parameter x will be found in this local scope as it's a parameter of this method 
    public static int multiply(int x){
        // looking for y in this local scope, but cannot find it
        // so will find y in the parent scope (y = 10)
        return x * y;
    }

    // defining B class inside A class
    static class B{
        public static int x = 15;

        public static int multiply(int x){
            // looking for y in this local scope, but cannot find it
            // so will find y in the parent scope (y = 10)
            return x * y;
        }
    }
}

class Main{

    public static void main(String[] args){
        int x = 33;
        System.out.println(x); // 33

        System.out.println(A.x); // 3

        System.out.println(A.multiply(5)); // 50

        System.out.println(A.B.x); // 15

        int y = 1000; // A.B.multiply(2) will find y in the parent scope (y = 10), so this y will not be used
        System.out.println(A.B.multiply(2)); // 20
    }
}
