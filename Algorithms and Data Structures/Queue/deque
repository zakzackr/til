public class Main {

    public static void main(String[] args) {
        Deque q = new Deque();

        q.enqueueBack(4);
        q.enqueueBack(50);

        System.out.println(q.peekFront()); // 4
        System.out.println(q.peekBack()); // 50

        q.enqueueFront(36);
        q.enqueueFront(96);

        System.out.println(q.peekFront()); // 96
        System.out.println(q.peekBack()); // 50
        System.out.println(q.dequeueBack()); // 50
        System.out.println(q.dequeueBack()); // 4
        System.out.println(q.peekFront()); // 96
        System.out.println(q.peekBack()); // 36

        q.enqueueFront(20);

        System.out.println(q.dequeueBack()); // 36
    }
}

class Node{
    public int data;
    public Node next;
    public Node prev;

    public Node(int data){
        this.data = data;
    }
}

class Deque{
    public Node head;
    public Node tail;

    public Deque(){};

    public void enqueueFront(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = head;
        } else {
//            Node temp = head;
//            head = newNode;
//            head.next = temp;
//            temp.prev = head;
            head.prev = newNode;
            head.prev.next = head;
            head = head.prev;
        }
    }

    public void enqueueBack(int data){
        Node newNode = new Node(data);
        if (tail == null) {
//            enqueueFront(data);
            tail = newNode;
            head = tail;
        } else {
//            tail.next = newNode;
//            newNode.prev = tail;
//            tail = newNode;
//            newNode.next = null;
            tail.next = newNode;
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    public Integer dequeueFront(){
        if (head == null) return null;

        Node temp = head;
        head = head.next;
        if (head == null) tail = null;
        else head.prev = null;
        return temp.data;
    }

    public Integer dequeueBack(){
        if (tail == null) return null;

        Node temp = tail;
        tail = tail.prev;
        if (tail == null) head = null;
        else tail.next = null;
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

