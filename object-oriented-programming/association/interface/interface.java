public class Main {
    public static void main(String[] args) {
        Audible p1 = new Person("John", "Stones", 30);
        Person p2 = new Person("Taylor", "Swift", 29);

        Audible h1 = new Horse("race", 2, 200, 18);
        Horse h2 = new Horse("domesticated", 1.7, 180, 14);

        Audible piano1 = new Piano(10, "Yamaha");
        Piano piano2 = new Piano(1, "Kawai");

        makeSound(p1);
        makeSound(h1);
        makeSound(piano1);

        makeSound(p2);
        makeSound(h2);
        makeSound(piano2);

        // ERROR, p1 is Audible type
//        p1.study();

        personInteractsWithObject(p2, piano1);
    }

    // Polymorphism
    public static void makeSound(Audible audibleObj){
        audibleObj.makeSound();
        System.out.println("sound frequency: " + audibleObj.soundFrequency());
        System.out.println("sound level: " +audibleObj.soundLevel());
        System.out.println(audibleObj);

        if (audibleObj instanceof Person) ((Person) audibleObj).study();
        System.out.println();
    }

    // Polymorphism
    public static void personInteractsWithObject(Person person, Audible audibleObj){
        System.out.println(person.getFullName() + " is interacting with " + audibleObj);
    }

}

interface Audible{
    public abstract void makeSound();
    public abstract double soundFrequency();
    public abstract double soundLevel();
}

class Person implements Audible{
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public void study(){
        System.out.println(getFullName() + " is studying!!");
    }

    public void makeSound(){
        System.out.println("Hello~");
    }

    public double soundFrequency(){
        return (age < 18)? 110: 130;
    }

    public double soundLevel(){
        return (age < 18)? 60: 65;
    }

    public String toString(){
        return "This is " + getFullName() + ".";
    }
}

class Horse implements Audible{
    private String type;
    private double heightM;
    private double weightKg;

    private int age;

    public Horse(String type, double heightM, double weightKg, int age){
        this.type = type;
        this.heightM = heightM;
        this.weightKg = weightKg;
        this.age = age;
    }

    public void makeSound(){
        System.out.println("Neeighh~");
    }

    public double soundFrequency(){
        return (age < 18)? 130: 180;
    }

    public double soundLevel(){
        return (age < 18)? 90: 105;
    }

    public String toString(){
        return "This is a " + type + " horse.";
    }
}

class Piano implements Audible{
    private int age;
    private String maker;

    public Piano(int age, String maker){
        this.age = age;
        this.maker = maker;
    }

    public void makeSound(){
        System.out.println("ドレミファソラシド");
    }

    public double soundFrequency(){
        return 100;
    }

    public double soundLevel(){
        return 80;
    }

    public String toString(){
        return "This is piano from "  + maker + "!!";
    }
}

