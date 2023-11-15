import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void animalPolymorphism(Animal animal){
        // can call methods all animal have
        System.out.println(animal);

        // ** When a person object is given...
        // ** if move method is overridden in Person class, the move method defined in Person class will be called
        // ** if move method is overridden in Mammal class, the move method defined in Mammal class will be called
        animal.move();
        animal.setAsHungry();
        System.out.println(animal.isHungry());

        // ERROR!!
        // cannot call methods that are specific to the subclass
        // In this case, only person can exercise/study and other animals (such as dog) cannot exercise/study
//        animal.exercise();
//        animal.study();
    }

    public static void main(String[] args) {
        Animal dog = new Animal("dog", 30, 25, 3000, "male");
        Mammal dogM = new Mammal("dog", 20, 15, 4000, "female", 5, "dog", 39.0);
        Person p1 = new Person(1.81, 67, "male", 36.5, "Ryu", "Suzuki");

        animalPolymorphism(dog);
        animalPolymorphism(dogM);
        animalPolymorphism(p1);
    }
}


class BMI{
    private double heightM;
    private double weightKg;

    public BMI(double heightM, double weightKg){
        this.heightM = heightM;
        this.weightKg = weightKg;
    }

    public double getValue(){
        return weightKg / (heightM * heightM);
    }

    public String toString(){
        return this.heightM + " meters, " + this.weightKg + "kg, BMI:" + this.getValue();
    }
}

class Animal{
    protected String species;
    protected BMI bmi;
    protected double lifeSpanDays;
    protected String biologicalSex;
    protected Date spawnTime;
    protected Date deathTime;
    protected int hungerPercent = 100;
    protected int sleepPercent = 100;

    public Animal(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex){
        this.species = species;
        this.bmi = new BMI(heightM, weightKg);
        this.lifeSpanDays = lifeSpanDays;
        this.biologicalSex = biologicalSex;
        this.spawnTime = new Date();
    }

    public void eat(){
        if (!isAlive()) return;
        hungerPercent = 0;
    }

    public void sleep(){
        if (!isAlive()) return;
        sleepPercent = 0;
    }


    public void setAsHungry(){
        if (!isAlive()) return;
        hungerPercent = 100;
    }

    public boolean isHungry(){
        return hungerPercent >= 70;
    }

    public void setAsSleepy(){
        if (!isAlive()) return;
        sleepPercent = 0;
    }

    public boolean isSleepy(){
        return sleepPercent >= 70;
    }

    public void die(){
        hungerPercent = 0;
        sleepPercent = 0;
        deathTime = new Date();
    }

    public boolean isAlive(){
        return deathTime == null;
    }

    public void move(){
        if (!isAlive()) return;
        System.out.println("The animal is moving...");
    }

    public String toString(){
        return this.species + this.bmi + " lives " + this.lifeSpanDays + " days/" + "gender:" + this.biologicalSex + "." + this.status();
    }

    public String status(){
        return this.species + " status:" + " Hunger - " + this.hungerPercent + "%, " + "sleepiness:"+this.sleepPercent + "%" + ", Alive - " + this.isAlive() + ". First created at " + this.dateCreated();
    }

    public String dateCreated(){
        return new SimpleDateFormat("yyyy/mm/dd HH:mm:ss").format(spawnTime);
    }
}

class Mammal extends Animal{
    private double furLengthCm;
    private String furType;
    private double bodyTemperatureC;
    private double avgBodyTemperatureC;
    private boolean mammaryGland = false;
    private boolean sweatGland = true;
    private boolean isPregnant = false;

    public Mammal(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, String furType, double avgBodyTemperatureC){
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex);

        this.furLengthCm = furLengthCm;
        this.furType = furType;
        this.mammaryGland = (biologicalSex == "female");
        this.bodyTemperatureC = avgBodyTemperatureC;
        this.avgBodyTemperatureC = avgBodyTemperatureC;
    }

    public void sweat(){
        if (!isAlive()) return;
        if(sweatGland) System.out.print("Sweating....");

        bodyTemperatureC -= 0.3;
        System.out.println("Body temperature is now " + bodyTemperatureC + "C");
    }

    public void produceMilk(){
        if (!isAlive()) return;
        if (isPregnant && mammaryGland) System.out.println("Producing milk...");
        else System.out.println("Cannot produce milk");
    }

    // override
    public void move(){
        if (!isAlive()) return;
        System.out.println(species + " is moving!!");
    }

    public void fertalize(){
        if(!isAlive()) return;

        isPregnant = true;
    }

    public void mate(Mammal mammal){
        if (!isAlive()) return;
        if (species == mammal.species) return;

        if (biologicalSex == "female" && mammal.biologicalSex == "male") fertalize();
        else if (biologicalSex == "male" && mammal.biologicalSex == "female") mammal.fertalize();
    }

    public String toString(){
        return "This is a mammal. " +  super.toString();
    }
}

class Name{
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }
}

class Person extends Mammal{
    private Name name;

    public Person(double heightM,
                  double weightKg,
                  String biologicalSex,
                  double avgBodyTemperatureC,
                  String firstName,
                  String lastName){
        super("human", heightM, weightKg, 30000, biologicalSex, 1.0, "human", avgBodyTemperatureC);

        this.name = new Name(firstName, lastName);
    }

    public void exercise(){
        System.out.println(name.getFullName() + " is exercising!!");
    }

    public void study(){
        System.out.println(name.getFullName() + " is studying!!");
    }

    public String toString(){
        return "This is a human. " + super.toString();
    }
}


