
public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class Stack{
    public Node head; // unlike Queue, you do not need to track tail node

    public Stack(){}

    // O(1)
    public void push(int data){
        Node temp = head;
        head = new Node(data);
        head.next = temp;
    }

    // O(1)
    // Will return null when head == null, so the returned data type should be Integer, instead of int
    public Integer pop(){
        if (head == null) return null;

        int temp = head.data;
        head = head.next;
        return temp;
    }

    public Integer peek(){
        if (head == null) return null;
        return head.data;
    }
}
