public class Main {

    public static void main(String[] args) {
        System.out.println(MathThings.PI);
        System.out.println(MathThings.circleSurfaceArea(2));
        System.out.println(MathThings.boxVolume(3));
    }
}

class MathThings{
    public static final double PI = 3.14159265359;

    // this method is accessible from anywhere in the application since it is declared with static keyword
    public static double circleSurfaceArea(int x){
        return x * x * PI;
    }

    public static double boxVolume(int x){
        return x * x * x;
    }
}
