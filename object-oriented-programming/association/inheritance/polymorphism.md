## Polymorphism

## Example
public class Main{
  public static void main(String[] args){
    Animal a1 = new Animal();
    Animal m1 = new Mammal();
    Animal p1 = new Person();

    a1.move();  // The Animal is moving
    m1.move();  // The Mammal is moving
    p1.move();  // The Person is moving

    // ERROR
    // p1.study();

    // casting
    if (p1 instanceof Animal) ((Person) p1).study();  // The Person is studying!!
  }
}

class Animal{
  public void move(){
    System.out.println("The animal is moving");
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
