
public class Main {
    public static void main(String[] args) {
        Person john = new Person("John", "Stones", 30);
        Person amy = new Person("Amy", "Yates", 26);
        Cow cow = new Cow("Japan", 1.7, 300);
        Fish fish = new Fish("Japan", 30, 20);
        Chicken chicken = new Chicken("Japan", 0.5, 10, 1);
        Pizza pizza = new Pizza();

        personInteractsWithAudible(john, cow);
        personInteractsWithAudible(john, amy);
        personEatsEdible(john, cow);
        personEatsEdible(john, fish);
        personEatsEdible(john, pizza);

        //
        Audible cowAudible = new Cow("Australia", 1.9, 300);
        personInteractsWithAudible(john, cowAudible);
        // ERROR!!
//        personEatsEdible(john, cowAudible);
    }

    public static void personInteractsWithAudible(Person p, Audible audibleObj){
        System.out.println(p + " interacts with " + audibleObj);
        p.makeNoise();
        audibleObj.makeNoise();
    }

    public static void personEatsEdible(Person p, Edible food){
        System.out.println(p + " eats " + food);
        System.out.println("HOW TO MAKE: " + food.howToPrepare());
        System.out.println("Calories: " + food.calories());
    }
}

interface Audible{
    public abstract void makeNoise();
    public abstract double soundFrequency();
    public abstract double soundLevel();
}

interface Edible{
    public abstract String howToPrepare();
    public abstract double calories();
}

class Person implements Audible{
    private String firstName;
    private String lastName;
    public int age;

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void makeNoise(){
        System.out.println("Hello World!!");
    }

    public double soundFrequency(){
        return (age > 18)? 130: 110;
    }

    public double soundLevel(){
        return (age > 18)? 120: 100;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String toString(){
        return "This is " + getFullName();
    }
}

class Cow implements Audible, Edible{
    private String country;
    private double heightM;
    private double weightKg;

    private double soundFrequency = 150;
    private double soundLevel = 160;

    public Cow(String country, double heightM, double weightKg){
        this.country = country;
        this.heightM = heightM;
        this.weightKg = weightKg;
    }

    public void makeNoise(){
        System.out.println("Mooooo~");
    }

    public double soundFrequency(){
        return soundFrequency;
    }

    public double soundLevel(){
        return soundLevel;
    }

    public String howToPrepare(){
        return "Grill it at 100C for 5 minutes.";
    }
    public double calories(){
        return (country == "Japan")? 1300: 1100;
    }

    public double getPrice(){
        double pricePerKg = 200;
        if (country == "Japan") pricePerKg *= 2;

        return weightKg * pricePerKg;
    }

    public String toString(){
        return "This cow is from " + country + ".";
    }
}

class Chicken implements Audible, Edible{
    private String country;
    private double heightM;
    private double weightKg;
    private int age;
    private double soundFrequency = 180;
    private double soundLevel = 100;

    public Chicken(String country, double heightM, double weightKg, int age){
        this.country = country;
        this.weightKg = weightKg;
        this.heightM = heightM;
        this.age = age;
    }

    public void makeNoise(){
        System.out.println("ChickenChicken~");
    }

    public double soundFrequency(){
        return soundFrequency;
    }

    public double soundLevel(){
        return soundLevel;
    }

    public String howToPrepare(){
        return "Boil it first and Grill it";
    }

    public double calories(){
        return 1000 * weightKg;
    }

    public String toString(){
        return "This chicken is from " + country + ".";
    }
}

class Fish implements Edible{
    private String country;
    private double heightM;
    private double weightKg;

    public Fish(String country, double heightM, double weightKg){
        this.country = country;
        this.heightM = heightM;
        this.weightKg = weightKg;
    }

    public String howToPrepare(){
        return "Cut into 3 pieces and boil/grill it";
    }

    public double calories(){
        return 500 * weightKg;
    }

    public String toString(){
        return "This fish is from " + country;
    }
}

class Pizza implements Edible{

    public String howToPrepare(){
        return "Use ingredients like tomatoes, cheese and onions";
    }

    public double calories(){
        return 700;
    }

    public String toString(){
        return "This is a pizza";
    }
}

