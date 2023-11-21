public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird("eagle", 100, 90);
        // object type casting
        Fly pigeonAsFly = new Bird("pigeon", 20, 30);

        AirPlane plane = new AirPlane("ANA", "Australia", 1000, 1000);
        // object type casting
        Fly planeAsFly = new AirPlane("Qantas", "England", 1200, 1000);

        flyMethod(bird);
        flyMethod(pigeonAsFly);
        flyMethod(plane);
        flyMethod(planeAsFly);
    }

    // This method takes an object of the class that implements Fly interface
    // can only implement methods from Fly interface in this method as flyObj is Fly type
    public static void flyMethod(Fly flyObj){
        flyObj.fly();
        System.out.println(flyObj.flightHeight());
        System.out.println(flyObj.flySpeed());
        System.out.println(flyObj);

        // By performing type-casting, flyObj created from Bird class will be treated as an instance of Bird objects.
        if (flyObj instanceof Bird) ((Bird) flyObj).birdMethod();

        System.out.println();
    }
}

interface Fly{
    public abstract void fly();
    public abstract double flightHeight();
    public abstract double flySpeed();
}

class Bird implements Fly{
    private String species;
    private double height;
    private double speed;

    public Bird(String species, double height, double speed){
        this.species = species;
        this.height = height;
        this.speed = speed;
    }

    public void fly(){
        System.out.println("This bird is flying...");
    }

    public double flightHeight(){
        return height;
    }

    public double flySpeed(){
        return speed;
    }

    public void birdMethod(){
        System.out.println("This method is called from Bird class");
    }

    public String toString(){
        return "This is a " + species;
    }
}

class AirPlane implements Fly{
    private String airline;
    private String destination;
    private double speed;
    private double height;

    public AirPlane(String airline, String destination, double speed, double height){
        this.airline = airline;
        this.destination = destination;
        this.speed = speed;
        this.height = height;
    }

    public void fly(){
        System.out.println("This plane from " + airline + " is flying to " + destination + "...");
    }

    public void birdMethod(){
        System.out.println("This method is called from Bird class");
    }

    public double flightHeight(){
        return height;
    }

    public double flySpeed(){
        return speed;
    }

    public String toString(){
        return "This is a " + airline + "'s plane";
    }
}



