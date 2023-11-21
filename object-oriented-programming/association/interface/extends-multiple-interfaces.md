## Extends multiple interfaces
An interface can extend any number of interfaces, unlike a class, which can extend only one other class.

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
interface DequeInt extends StackInt, QueueInt{
    public abstract void addFirst(int element);
}

abstract class AbstractListInteger implements DequeInt{ ... }

// implementing all of the abstract methods in the abstract class and interfaces above
// a class can extend only one other class
class IntegerLinkedList extends AbstractListInteger{ ... }
```
