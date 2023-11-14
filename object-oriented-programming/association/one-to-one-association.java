// This is an example of aggregation.
// A Person HAS-A Wallet and the wallet can exist after the person is deleted.

public class Main {
  
    public static void main(String[] args) {
        Person John = new Person("John", "Suzuki", 18, 1.87, 85);
        John.printState();
        John.getPaid(123);
        John.printState();
        John.spendMoney(100);
        John.printState();
        John.dropWallet();
        John.printState();

        System.out.println();
        Person Kelly = new Person("Kelly", "Kato", 21, 1.67, 50);
        Kelly.printState();
        Kelly.setDenominationPreference("dollars");
        Kelly.getPaid(321);
        Kelly.printState();
        Kelly.spendMoney(322);
        Kelly.printState();
        Kelly.spendMoney(125);
        Kelly.printState();

        System.out.println();
        Person Amy = new Person("Amy", "Tanaka", 27, 1.57, 49);
        Amy.setDenominationPreference("twenties");
        Amy.getPaid(1236);
        Amy.printState();
        Amy.spendMoney(1220);
        Amy.printState();
        Amy.addWallet(new Wallet(0, 2, 20, 1, 2, 100));
        Amy.printState();
        Amy.spendMoney(20);
        Amy.printState();
    }
}

class Person{
    private String firstName;
    private String lastName;
    private int age;
    private double heightM;
    private double weightKg;
    private String denomination = "highestFirst";  // if you define this variable with static keyword, a change to this variable will affect other instances of this class.
    private Wallet wallet;

    public Person(String firstName, String lastName, int age, double heightM, double weightKg){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.heightM = heightM;
        this.weightKg = weightKg;
        this.wallet = new Wallet();
    }

//    public Person(String firstName, String lastName, int age, double heightM, double weightKg, int initialMoney){
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.heightM = heightM;
//        this.weightKg = weightKg;
//    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public int getCash(){
        if (wallet == null) return 0;
        return wallet.getTotalMoney();
    }

    public int[] getPaid(int money){
        if (wallet == null) return new int[6];

        int[] addedMoney = allocateMoney(money);
        int[] bills = {1, 5, 10, 20, 50, 100};

        for (int i = bills.length - 1; i >= 0; i--){
            wallet.insertBill(bills[i], addedMoney[i]);
        }

        return addedMoney;
    }

    public int[] spendMoney(int money) {
        if (wallet == null) return new int[6];

        int[] spentMoney = allocateMoney(money);
        int[] bills = {1, 5, 10, 20, 50, 100};

        for (int i = bills.length - 1; i >= 0; i--){
            wallet.removeBill(bills[i], spentMoney[i]);
        }

        return spentMoney;
    }

    public int[] allocateMoney(int money){
        int[] allocatedMoney = new int[6];
        int[] bills = new int[]{1, 5, 10, 20, 50, 100};

        if (denomination == "highestFirst"){
            for (int i = bills.length - 1; i >= 0; i--){
                if (money >= bills[i]){
                    allocatedMoney[i] = money / bills[i];
                    money %= bills[i];
                }
            }
        } else if (denomination == "dollars"){
            allocatedMoney[0] = money;
        } else if (denomination == "twenties"){
            for (int i = 3; i >= 0; i--){
                if (money >= bills[i]){
                    allocatedMoney[i] = money / bills[i];
                    money %= bills[i];
                }
            }
        }

        return allocatedMoney;
    }

    public void addWallet(Wallet wallet){
        this.wallet = wallet;
    }

    public Wallet dropWallet(){
        Wallet dropped = wallet;
        wallet = null;

        return dropped;
    }

    public void setDenominationPreference(String denomination){
        this.denomination = denomination;
    }

    public void printState(){
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("age: " + age);
        System.out.println("heightM: " + heightM);
        System.out.println("weightKg: " + weightKg);
        System.out.println("current Money: " + (wallet == null? "wallet does not exsist...": wallet.getTotalMoney()));
        if (wallet != null) wallet.printInsideWallet();
    }
}

class Wallet{
    private int bill1;
    private int bill5;
    private int bill10;
    private int bill20;
    private int bill50;
    private int bill100;

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
        return 1 * bill1 + 5 * bill5 + 10 * bill10 + 20 * bill20 + 50 * bill50 + 100 * bill100;
    }

    public int insertBill(int bill, int amount){
        switch (bill){
            case 1:
                bill1 += amount;
                break;
            case 5:
                bill5 += amount;
                break;
            case 10:
                bill10 += amount;
                break;
            case 20:
                bill20 += amount;
                break;
            case 50:
                bill50 += amount;
                break;
            case 100:
                bill100 += amount;
                break;
            default:
                return 0;
        }

        return bill * amount;
    }

    public int removeBill(int bill, int amount){
        switch (bill){
            case 1:
                if (bill1 <= 0 || bill1 < amount) return 0;
                bill1 -= amount;
                break;
            case 5:
                if (bill5 <= 0 || bill5 < amount) return 0;
                bill5 -= amount;
                break;
            case 10:
                if (bill10 <= 0 || bill10 < amount) return 0;
                bill10 -= amount;
                break;
            case 20:
                if (bill20 <= 0 || bill20 < amount) return 0;
                bill20 -= amount;
                break;
            case 50:
                if (bill50 <= 0 || bill50 < amount) return 0;
                bill50 -= amount;
                break;
            case 100:
                if (bill100 <= 0 || bill100 < amount) return 0;
                bill100 -= amount;
                break;
            default:
                return 0;
        }

        return bill * amount;
    }

    public void printInsideWallet(){
        System.out.println("Inside wallet (bill1: " + bill1 + ", bill5: " + bill5 + ", bill10: " + bill10 + ", bill20: " + bill20 + ", bill50: " + bill50 + ", bill100: " + bill100 + ")");
    }
}
