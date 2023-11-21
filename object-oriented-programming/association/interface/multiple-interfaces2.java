public class Main {
    public static void main(String[] args) {
        Person john = new Person("John", "Stones", 30);
        Person amy = new Person("Amy", "Yates", 26);
        Cow cow = new Cow("Japan", 1.7, 300);
        Fish fish = new Fish("Japan", 30, 20);

        lensSeesObject(john, cow);
        lensSeesObject(cow, amy);
        lensSeesObject(fish, cow);
    }

    public static void lensSeesObject(Lenses lens, Audible audibleObj){
        System.out.println(lens.see(audibleObj));
        System.out.println("This lens object can see lights between " + lens.lightRange()[0] + " and " + lens.lightRange()[1]);
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

interface Lenses{
    public abstract int[] lightRange();
    public abstract String see(Audible AudibleObj);
}


class Person implements Audible, Lenses{
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

    public int[] lightRange(){
        return new int[]{400, 700};
    }

    public String see(Audible AudibleObj){
        return getFullName() + " sees " + AudibleObj;
    }

    public String toString(){
        return "This is " + getFullName();
    }
}

class Cow implements Audible, Edible, Lenses{
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

    public int[] lightRange(){
        return new int[]{200, 350};
    }

    public String see(Audible AudibleObj){
        return "This cow sees " + AudibleObj;
    }

    public double getPrice(){
        double pricePerKg = 200;
        if (country == "Japan") pricePerKg *= 2;

        return weightKg * pricePerKg;
    }

    public String toString(){
        return "a cow from " + country + ".";
    }
}

class Fish implements Edible, Lenses {
    private String country;
    private double heightM;
    private double weightKg;

    public Fish(String country, double heightM, double weightKg) {
        this.country = country;
        this.heightM = heightM;
        this.weightKg = weightKg;
    }

    public String howToPrepare() {
        return "Cut into 3 pieces and boil/grill it";
    }

    public double calories() {
        return 500 * weightKg;
    }

    public String toString() {
        return "a fish from " + country;
    }

    public int[] lightRange(){
        return new int[]{10, 50};
    }

    public String see(Audible AudibleObj){
        return "This fish sees " + AudibleObj;
    }
}

class Car implements Audible{
    private String maker;
    private String carType;

    public Car(String maker, String carType){
        this.maker = maker;
        this.carType = carType;
    }

    public void makeNoise(){
        System.out.println("BeepBeep!!!");
    }

    public double soundFrequency(){
        return (carType == "sport")? 200: 120;
    }

    public double soundLevel(){
        return (carType == "sport")? 170: 100;
    }
}
