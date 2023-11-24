public class Main {
    public static void main(String[] args) {
        // Contains only one data type
        Stack stackInt = new Stack(new Integer[]{1, 2, 3, 4, 5, 6});
        Stack stackStr = new Stack(new String[]{"apple", "banana", "Cherry", "dragon fruit"});

        System.out.println(stackInt);
        System.out.println(stackStr);

        // Contains many data types...
        Animal animal = new Animal("Lion");
        Person person = new Person("John");

        // As every class directly/indirectly inherits the Object class, this stack contains Integer, String, Animal and Person classes.
        // -> causing errors, e.g. stackMultiTypes.pop() * stackMultiTypes.pop()
        // Stack should be a list that contains only one data type. -> we should use 'generics'
        Stack stackMultiTypes = new Stack(new Object[]{1, animal, "lemon", person});
        System.out.println(stackMultiTypes);

        // ERROR!!
        // System.out.println(stackMultiTypes.pop() * stackMultiTypes.pop());
    }
}

class Node{
    public Object data;
    public Node next;

    public Node(Object data){
        this.data = data;
    }
}

class Stack{
    public Node head;

    public Stack(){}

    public Stack(Object[] objects){
        if (objects == null){
            this.head = null;
            return;
        }

        this.head = new Node(objects[0]);
        Node current = this.head;

        for (int i = 1; i < objects.length; i++){
            current.next = new Node(objects[i]);
            current = current.next;
        }
    }

    public void push(Object obj){
        Node newNode = new Node(obj);
        if (head == null) head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public Object pop(){
        if (head == null) return null;

        Node deleted = head;
        head = head.next;

        return deleted.data;
    }

    public Object peek(){
        return (head != null)? head.data: null;
    }

    public String toString(){
        if (head == null) return "[]";

        Node current = head;
        StringBuilder sb = new StringBuilder("[");

        while (current != null){
            if (current.next != null) sb.append(current.data + " ");
            else sb.append(current.data);

            current = current.next;
        }

        return sb.append("]").toString();
    }
}

class Animal{
    public String species;

    public Animal(String species){
        this.species = species;
    }

    public String toString(){
        return species;
    }
}

class Person{
    public String name;

    public Person(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
