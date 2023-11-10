import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        Person take = new Person("Take", "Kubo", 2002, 1.72, 68);
        System.out.println(take.getAge());
        System.out.println(take);
        take.changeName("Taro", "Sato");
        System.out.println(take);

        // error
//        System.out.println(take.getFullName());
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
