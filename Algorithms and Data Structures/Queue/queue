public class Main {

    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.peekFront());
        System.out.println(q.peekBack());

        q.enqueue(4);
        System.out.println(q.peekFront());
        System.out.println(q.peekBack());

        q.enqueue(50);
        System.out.println(q.peekFront());  // 4
        System.out.println(q.peekBack());  // 5

        q.enqueue(64);
        System.out.println(q.peekFront());
        System.out.println(q.peekBack());

        System.out.println("dequeued :" + q.dequeue());
        System.out.println(q.peekFront());
        System.out.println(q.peekBack());
    }
}

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class Queue{
    public Node head;
    public Node tail;

    public Queue(){}

    public void enqueue(int data){
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            head = tail;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public Integer dequeue(){
        if (head == null) return null;

        Node temp = head;
        head = head.next;
        if (head == null) tail = null;
        return temp.data;
    }

    public Integer peekFront(){
        if (head == null) return null;
        return head.data;
    }

    public Integer peekBack(){
        if (tail == null) return null;
        return tail.data;
    }
}



