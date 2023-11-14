// Person object owns Name/BMI objects.

public class Main {
    public static void main(String[] args) {
        Person john = new Person("John", "Stones", 1.87, 86);
        Person anna = new Person("Anna", "Suzuki", 1.68, 52);

        // When john and anna objects are deleted, their Name and BMI are also deleted.
        // Other people cannot have the deleted Name or BMI as they are unique to the person.
        john =  null;
        anna = null;

        // There are no ways to access john/anna's BMI and Name anymore.
    }
}

// After person objects are deleted, Name objects will be also deleted.
class Name{
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString(){
        return firstName + " " + lastName;
    }
}

// After person objects are deleted, BMI objects will be also deleted. 
class BMI{
    private double heightM;
    private double weightKg;

    public BMI(double heightM, double weightKg){
        this.heightM = heightM;
        this.weightKg = weightKg;
    }

    public double getBMI(){
        return weightKg / (heightM * heightM);
    }

    public String toString(){
        return "height: " + heightM + "m, weight: " + weightKg + "kg, BMI: " + getBMI();
    }

}

class Person {
    private Name name;  // Composition
    private BMI bmi;  // Composition

    // In the constructor of Person class, Name/BMI objects are created and Composition is formed.
    public Person(String firstName, String lastName, double heightKg, int weightKg) {
        this.name = new Name(firstName, lastName);
        this.bmi = new BMI(heightKg, weightKg);
    }
}
