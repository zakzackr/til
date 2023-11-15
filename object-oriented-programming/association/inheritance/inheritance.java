import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Animal("dog", 30, 25, 3000, "male");
        Mammal dogM = new Mammal("dog", 20, 15, 4000, "female", 5, "dog", 39.0);

        System.out.println(dog);
        System.out.println(dogM);

        dogM.setAsHungry();
        System.out.println(dogM.isSleepy());
        dogM.move();  // overloaded move method
        dog.move();  // move method in super class

        dogM.bite();
        dogM.replaceTooth();
        dogM.bite();
        dogM.produceMilk();
        dogM.fertalize();
        dogM.produceMilk();
        dogM.sweat();
        dogM.die();
        System.out.println(dogM.isAlive());
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
    private int toothCounter;
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

    // overload
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

    public void bite(){
        if (!isAlive()) return;
        System.out.println(species + " bites with its teeth that are " + ((toothCounter == 0)? "not replaced.": "replaced."));
        System.out.println();
    }

    public void replaceTooth(){
        if (!isAlive()) return;
        if (toothCounter < 1) toothCounter += 1;
    }
}
