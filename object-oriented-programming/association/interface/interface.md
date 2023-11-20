## Interface
Interfaces enable abstraction.  
    
### Basic Rule
1. Interface can only have abstract methods. (Abstract class can have concrete methods and member variables in addition to abstract methods.)
2. A class that implements an interface has to implement abstract methods defined in the interface.
3. A class can implements multiple interfaces.  
    
### Interface and Polymorphism
When Person class implements Audible interface, Person class must implements all of the abstract methods defined in the interface. Person objects can be defined as Audible type.
    
```
public class Main {
    public static void main(String[] args) {
        Audible p1 = new Person("John", "Stones", 30);
        Person p2 = new Person("Taylor", "Swift", 29);

        makeSound(p1);
        makeSound(p2);
    }

    // Polymorphism
    // p1 can be passed to this method as it is defined as Audible type
    // p2 can be also passed to this method as Person class implements Audible interface.
    public static void makeSound(Audible audibleObj){
        audibleObj.makeSound();
    }
}

interface Audible{
    public abstract void makeSound();
}

class Person implements Audible{

    public void makeSound(){
        System.out.println("Hello~");
    }
}

```
