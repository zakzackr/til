// You can manually set default values for member variables. 
// These default values will be assigned before the constructor is executed.

public class Main {

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p);
        System.out.println(p.lastName);
        System.out.println(p.heightM);

        Wallet defaultWallet = new Wallet();
        System.out.println(defaultWallet.getTotalMoney());

        Person p1 = new Person("Adam", "Suzuki", 22, 1.81, 67);
        System.out.println(p1.wallet);
        System.out.println(p1);
        System.out.println(p1.getCash());
        p1.addWallet(new Wallet(1, 1, 1, 1, 1, 1));
        System.out.println(p1.getCash());
    }
}

class Wallet{
    public int bill1 = 10;  // manually setting the default value of bill1
    public int bill5 = 10;
    public int bill10;  // default value is 0
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
}

class Person{
    public String firstName = "Amy";
    public String lastName;  // dafault value is null
    public int age;
    public double heightM;
    public double weightKg;
    public Wallet wallet = new Wallet(10, 10, 10, 10, 10, 10);

    public Person(){};

    public Person(String firstName, String lastName, int age, double heightM, double weightKg){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.heightM = heightM;
        this.weightKg = weightKg;
    }

    public int getCash(){
        if (wallet == null) return 0;
        return wallet.getTotalMoney();
    }

    public void addWallet(Wallet newWallet){
        wallet = newWallet;
    }

    public String toString(){
        return firstName + " " + lastName + ".";
    }
}
