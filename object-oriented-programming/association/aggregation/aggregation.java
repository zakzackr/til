
public class Main {
    public static void main(String[] args) {
        Person john = new Person("John", "Stones", 29);
        john.printState();
        john.receiveBill(100, 1000);
        john.printState();
        Wallet droppedWallet = john.dropWallet();  // After John dropped his wallet, the wallet can remain.
        john.printState();

        Person anna = new Person("Anna", "Suzuki", 21);
        anna.printState();
        anna.addWallet(droppedWallet);  // Now Anna has John's droppedWallet.
        anna.printState();
    }
}

class Wallet{
    private int bill1;
    private int bill5;
    private int bill10;
    private int bill20;
    private int bill50;
    private int bill100;

    public Wallet(){}

    public int getTotalMoney(){
        return (1 * bill1) + (5 * bill5) + (10 * bill10) + (20 * bill20) + (50 * bill50) + (100 * bill100);
    }

    public int insertBill(int bill, int amount){
        switch(bill){
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

        return bill*amount;
    }
}

class Person {
    private String firstName;
    private String lastName;
    private int age;

    // Person class has Wallet class.
    // aggregation（集約）: Even if the person object disappears, the wallet object still remains.
    private Wallet wallet;

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;


        // When a person object is created, the person's wallet will be created.
        // However, the wallet object can remain after the person object is deleted.
        this.wallet = new Wallet();
    }

    public int getCash(){
        if (wallet == null) return 0;
        return wallet.getTotalMoney();
    }

    public int receiveBill(int bill, int amount){
        return wallet.insertBill(bill, amount);
    }

    // The person drops his/her wallet, but the wallet itself can still remain.
    public Wallet dropWallet(){
        Wallet dropped = wallet;
        wallet = null;
        return dropped;
    }

    public void addWallet(Wallet newWallet){
        wallet = newWallet;
    }

    public void printState(){
        System.out.println("firstname - " + this.firstName);
        System.out.println("lastname - " + this.lastName);
        System.out.println("age - " + this.age);
        System.out.println("Current Money - " + this.getCash());
        System.out.println();
    }
}
