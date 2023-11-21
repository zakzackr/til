## Extends multiple interfaces
An interface can extend any number of interfaces, unlike a class, which can extend only one other class. So, the child interface inherits the abstract methods of the parent interface.

### Example
ref: object-oriented-programming/association/interface/data-structure-interfaces.java
```
interface StackInt{
    public abstract Integer peekLast();
    public abstract Integer pop();
    public abstract void push(int element);
}

interface QueueInt{
    public abstract Integer peekFirst();
    public abstract Integer poll();
    public abstract void push(int element);
}

// can extend multiple interfaces
// will inherit all of the abstract methods from StackInt and QueueInt interfaces
interface DequeInt extends StackInt, QueueInt{

    // defining a abstract method unique to DequeInt
    public abstract void addFirst(int element);
}

// ** cannot create an instance directly from an abstract class but still can define constructors in an abstract class. 
// ** a constructor of an abstract class can be called from its subclass using super().
abstract class AbstractListInteger implements DequeInt{ ... }

// this class implements all of the abstract methods in the abstract class and interfaces above
// a class can extend only one other class
class IntegerLinkedList extends AbstractListInteger{ ... }
```
