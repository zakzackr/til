public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Batrunner", 2000, 200, 60, 1000);
        Monster gorilla = new Monster("Gorilla", 4000, 40, 100);
        Monster vampire = new Monster("Vampire", 6000, 160, 20);

        System.out.println(p1);
        System.out.println(gorilla);
        System.out.println(vampire);

        p1.attack(gorilla);
        p1.attack(vampire);

        System.out.println(gorilla);
        System.out.println(vampire);
    }
}

class Player{
    private String username;
    private int health;
    private int attack;
    private int defense;
    private double height = 1.8;  // All players are 1.8 meters
    private int gold;

    public Player(String username, int health, int attack, int defense, int gold){
        this.username = username;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.gold = gold;
    }

    // Return the player's height in meters
    public double getHeight(){
        return this.height;
    }

    // There is a dependency between Player and Monster class.
    // This method uses Monster class, which means Player class depends on Monster class.
    // If some changes are made in the Monster class, the Player class may get affected.
    public void attack(Monster monster){
        System.out.println(username + " attacks " + monster.getName());

        // Now, I have changed the monster's height from meters to cm
        if (height * 3 > monster.getHeight()  && attack > monster.getDefense()){
            monster.attacked(attack - monster.getDefense());
        }
    }

    public String toString(){
        return "Player " + this.username + " - HP:" + this.health +"/Atk:" + this.attack + "/Def:" + this.defense + "/Gold:" + this.gold + "/height:" + this.height + " meters";
    }
}

class Monster{
    private String monster;
    private int health;
    private int attack;
    private int defense;

    // changed heightM to heightCM
    private double height = 300;  // All monsters are 300 cm

    public Monster(String monster, int health, int attack, int defense){
        this.health = health;
        this.monster = monster;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName(){
        return this.monster;
    }

    // Return the monster's height in cm
    public double getHeight(){
        return this.height;
    }

    public int getDefense(){
        return this.defense;
    }

    public void attacked(int hp){
        health -= hp;
        if (health <= 0) health = 0;
    }

    public String toString(){
        return this.monster + " - HP:" + this.health +"/Atk:" + this.attack + "/Def:" + this.defense + "/height:" + this.height + " cm";
    }
}
