import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        Person john = new Person("John", "Stones", 1991, 1.91, 84);
        System.out.println(john.getFirstName());
        john.setFirstName("Johnson");

        System.out.println(john.getLastName());
        john.setLastName("Stone");
        System.out.println(john.getHeightM());
        System.out.println(john.getWeightKg());
        System.out.println(john);

        // error
//        System.out.println(john.firstName);
    }
}

class Person{
    private String firstName;
    private String lastName;
    private int birthYear;
    private double heightM;
    private double weightKg;

    public Person(String firstName, String lastName, int birthYear, double heightM, double weightKg){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.heightM = heightM;
        this.weightKg = weightKg;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public double getHeightM(){
        return this.heightM;
    }

    public void setHeightM(double heightM){
        this.heightM = heightM;
    }

    public double getWeightKg(){
        return this.weightKg;
    }

    public void setWeightKg(double weightKg){
        this.weightKg = weightKg;
    }

    public int getBirthYear(){
        return this.birthYear;
    }

    private String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public int getAge(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - this.birthYear;
    }

    public void changeName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString(){
        return "name: " + getFullName() + ", age: " + getAge() + ", heightM: " + heightM + ", weightKg: " + weightKg;
    }
}
