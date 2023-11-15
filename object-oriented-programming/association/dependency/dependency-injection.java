import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Batrunner", 2000, 200, 60, 1000);
        Monster gorilla = new Monster("Gorilla", 4000, 40, 100);
        Monster vampire = new Monster("Vampire", 6000, 160, 20);

        Field field = new Field();
        // We give some parameters, but we don't consider dependencies
        field.randomlyAdd("dog", 3000, 5, 5);
        // We give Monster objects as input, which shows that Filed class is dependent on Monster class
        field.randomlyAddWithDependency(gorilla);
        field.randomlyAddWithDependency(vampire);

        System.out.println(field);
    }
}

class Player{
    private String username;
    private int health;
    private int attack;
    private int defense;
    private double height = 1.8;
    private int gold;

    public Player(String username, int health, int attack, int defense, int gold){
        this.username = username;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.gold = gold;
    }

    public double getHeight(){
        return this.height;
    }

    public void attack(Monster monster){
        System.out.println(username + " attacks " + monster.getName());

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

    private double height = 3;

    public Monster(String monster, int health, int attack, int defense){
        this.health = health;
        this.monster = monster;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName(){
        return this.monster;
    }

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
        return this.monster + " - HP:" + this.health +"/Atk:" + this.attack + "/Def:" + this.defense + "/height:" + this.height + "meters";
    }
}

class Coordinate{
    private int x;
    private int y;
    private int z;

    public Coordinate(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString(){
        return "{x:" + x + ", y:" + y + ",z:" + z + "}";
    }
}

class Field{
    private static final int MAX_X = 100000;
    private static final int MAX_Y = 40000;
    private static final int MAX_Z = 1000;

    private ArrayList<Monster> creatures;
    private ArrayList<Coordinate> creatureCoordinates;

    public Field(){
        this.creatures = new ArrayList<>();
        this.creatureCoordinates = new ArrayList<>();
    }

    // This method is dependent on Monster class, but cannot see the dependency from outside (blackbox)
    public void randomlyAdd(String monster, int health, int attack, int defense){
        Monster m = new Monster(monster, health, attack, defense);
        Coordinate c = new Coordinate(internalRanAlgorithm(0, MAX_X), internalRanAlgorithm(0, MAX_Y), internalRanAlgorithm(0, MAX_Z));

        creatures.add(m);
        creatureCoordinates.add(c);
    }

    // Instead of creating a new Monster object inside a method, pass a Monster object to a method from outside
    // This explicitly shows that this method(Field class) are dependent on Monster class
    public void randomlyAddWithDependency(Monster monster){
        Coordinate c = new Coordinate(internalRanAlgorithm(0, MAX_X), internalRanAlgorithm(0, MAX_Y), internalRanAlgorithm(0, MAX_Z));
        creatures.add(monster);
        creatureCoordinates.add(c);
    }

    private int internalRanAlgorithm(int min, int max){
        return (int)Math.floor(Math.random() * (max - min) + min) ;
    }

    public String toString(){
        StringBuffer s = new StringBuffer("");
        for(int i = 0; i < creatures.size(); i++){
            s.append(creatures.get(i) + " with coordinates: " + creatureCoordinates.get(i) + "\n");
        }

        return s.toString();
    }
}

