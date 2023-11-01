public class Main {

    public static void main(String[] args) {
        System.out.println(getMax(new int[]{2, 5, 26, 345, 75, 34}));
    }

    public static int getMax(int[] arr){
        Deque deque = new Deque();
        deque.enqueueFront(arr[0]);

        for (int i = 1; i < arr.length; i++){
            if (arr[i] > deque.peekFront()){
                deque.enqueueFront(arr[i]);
            }
        }

        return deque.peekFront();
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





