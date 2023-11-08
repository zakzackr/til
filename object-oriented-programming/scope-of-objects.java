public class Main {

    public static void main(String[] args) {
        Person p = new Person("Ryu","Poolhopper", 40, 180, 140);
        System.out.println(p);

        p.wallet.insertBill(1, 5);
        p.wallet.insertBill(10, 10);
        System.out.println(p);
    }
}

class Wallet{
    public int bill1;
    public int bill5;
    public int bill10;
    public int bill20;
    public int bill50;
    public int bill100;

    public Wallet(){};

    public Wallet(int bill1, int bill5, int bill10, int bill20, int bill50, int bill100){
        this.bill1 = bill1;
        this.bill5 = bill5;
        this.bill10 = bill10;
        this.bill20 = bill20;
        this.bill50 = bill50;
        this.bill100 = bill100;
    }

    public int getTotalMoney(){
        return (1 * bill1) + (5 * bill5) + (10 * bill10) + (20 * bill20) + (50 * bill50) + (100 * bill100);
    }

    public void insertBill(int bill, int amount){
        switch (bill){
            case(1):
                bill1 += amount;
                break;
            case (5):
                bill5 += amount;
                break;
            case (10):
                bill10 += amount;
                break;
            case (20):
                bill20 += amount;
                break;
            case(50):
                bill50 += amount;
                break;
            case(100):
                bill100 += amount;
                break;
        }
    }
}

class Person{
    public String firstName;
    public String lastName;
    public int age;
    public double heightM;
    public double weightKg;
    public Wallet wallet;

    public Person(){};

    public Person(String firstName, String lastName, int age, double heightM, double weightKg){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.heightM = heightM;
        this.weightKg = weightKg;
        this.wallet = new Wallet();
    }

    public int getCash(){
        if (wallet == null) {
            System.out.println("No wallet...");
            return 0;
        }
        return wallet.getTotalMoney();
    }

    public String toString(){
        return "name: " + firstName + " " + lastName + ", wallet: $" + getCash() + ".";
    }
}
