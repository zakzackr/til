## Polymorphism and Dynamic Binding

## Example
```
public class Main{
    public static void main(String[] args){

        // a1, m1, and p1 are Animal types, only accessible to methods defined in the Animal class.
        Animal a1 = new Animal();
        Animal m1 = new Mammal();  // assigning a Mammal class object to parent class reference. 
        Animal p1 = new Person();  // assigning a Person class object to parent class reference. 

        a1.move();  // The Animal is moving
        m1.move();  // The Mammal is moving
        p1.move();  // The Person is moving

        // ERROR!!
        // The study method is defined in the Person class, so only person objects can call the method.
        // In this case, p1 is Animal type, not Person type.
        // p1.study();

        // Casting
        if (p1 instanceof Animal) ((Person) p1).study();  // The Person is studying!!

        polyMethod(a1);  // The Animal is moving
        polyMethod(m1);  // The Mammal is moving
        polyMethod(p1);  // The Person is moving,  The Person is studying!!


        // a2: Animal type, m2: Mammal type, p2: Person type.
        Animal a2 = new Animal();
        Mammal m2 = new Mammal();
        Person p2 = new Person();

        polyMethod(a2);  // The Animal is moving
        polyMethod(m2);  // The Mammal is moving
        polyMethod(p2);  // The Person is moving,  The Person is studying!!
    }

    public static void polyMethod(Animal animal){
        animal.move();
        if (animal instanceof Person) ((Person) animal).study();
    }
}

class Animal{
    public void move(){
        System.out.println("The Animal is moving");
    }
}

class Mammal extends Animal{
    public void move(){
        System.out.println("The Mammal is moving");
    }
}

class Person extends Mammal{
    public void move(){
        System.out.println("The Person is moving");
    }

    public void study(){
        System.out.println("The Person is studying!!");
    }
}
```
