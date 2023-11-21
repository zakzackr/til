public class Main {
    public static void main(String[] args) {
        StackInt stack = new IntegerLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        QueueInt queue = new IntegerLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        DequeInt dequeEven = new IntegerLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        DequeInt dequeOdd = new IntegerLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7});
        AbstractListInteger list = new IntegerLinkedList(new int[]{1, 2, 3, 4, 5, 6});

        System.out.println(list.getOriginalList()[0]);  // 1

        stackPrint(stack);  // [6 5 4 3 2 1 ]
//        stackPrint(list); // [6 5 4 3 2 1 ]
        queuePrint(queue);  // [1 2 3 4 5 6 ]
//        queuePrint(list); // [1 2 3 4 5 6 ]
        dequePrint(dequeEven);  // [1 6 2 5 3 4 ]
//        dequePrint(list);  // [1 6 2 5 3 4 ]
        dequePrint(dequeOdd);  // [1 7 2 6 3 5 4 ]
        abstractListIntegerPrint(list);  // [1 2 3 4 5 6 ]

        DequeInt deque = new IntegerLinkedList();
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        deque.push(4);
        deque.push(5);
        deque.push(6);
//        queuePrint(deque);  // [1 2 3 4 5 6 ]
//        stackPrint(deque);  // [6 5 4 3 2 1 ]
//        dequePrint(deque);  // [1 6 2 5 3 4 ]
    }

    public static void stackPrint(StackInt s){
        System.out.print("[");
        while (s.peekLast() != null){
            System.out.print(s.pop() + " ");
        }

        System.out.println("]");
    }

    public static void queuePrint(QueueInt q){
        System.out.print("[");
        while (q.peekFirst() != null){
            System.out.print(q.poll() + " ");
        }

        System.out.println("]");
    }

    public static void dequePrint(DequeInt d){
        System.out.print("[");
        while (d.peekFirst() != null){
            System.out.print(d.poll() + " ");
            if (d.peekLast() != null) System.out.print(d.pop() + " ");
        }

        System.out.println("]");
    }

    public static void abstractListIntegerPrint(AbstractListInteger l){
        System.out.print("[");
        while (l.peekFirst() != null){
            System.out.print(l.poll() + " ");
        }

        System.out.println("]");
    }
}

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

interface DequeInt extends StackInt, QueueInt{
    public abstract void addFirst(int element);
}

abstract class AbstractListInteger implements DequeInt{
    protected int[] initialArr;

    public AbstractListInteger(){}

    public AbstractListInteger(int[] arr){
        this.initialArr = arr;
    }

    public int[] getOriginalList(){
        return this.initialArr;
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

class IntegerLinkedList extends AbstractListInteger{
    protected Node head;
    protected Node tail;

    public IntegerLinkedList(){
        super();
    }

    public IntegerLinkedList(int[] arr){
        super(arr);

        if (arr.length >= 1){
            this.head = new Node(arr[0]);

            Node current = this.head;
            for (int i = 1; i < arr.length; i++){
                current.next = new Node(arr[i]);
                current.next.prev = current;
                current = current.next;
            }

            this.tail = current;
        }
    }

    public Integer peekLast(){
        if (tail == null) return null;
        return tail.data;
    }

    public Integer pop(){
        if (tail == null) return null;
        Node deleted = tail;
        tail = deleted.prev;
        if (tail == null) head = null;
        else tail.next = null;

        return deleted.data;
    }

    public void push(int element){
        Node newNode = new Node(element);

        if (tail == null){
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public Integer peekFirst(){
        if (head == null) return null;
        return head.data;
    }

    public Integer poll(){
        if (head == null) return null;

        Node deleted = head;
        head = head.next;
        if (head == null) tail = null;
        else head.prev = null;

        return deleted.data;
    }

    // have already implemented push method from StackInt interface
//    public void push(int element);

    public void addFirst(int element){
        Node newNode = new Node(element);

        if (head == null){
            head = newNode;
            tail = head;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }
}
