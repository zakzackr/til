public class Main {

    public static void main(String[] args) {
        DoublyLinkedList numList = new DoublyLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7});
        numList.printList();
        numList.printReverse();
        numList.reverse();;
        numList.printList();

        numList.preAppend(new Node(45));
        numList.append(new Node(77));
        System.out.println(numList.head.data);
        System.out.println(numList.tail.data);
        numList.printList();

        numList.addNextNode(numList.at(3), new Node(33));
        numList.printList();
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

class DoublyLinkedList{
    public Node head;
    public Node tail;

    public DoublyLinkedList(int[] initialArr){
        if (initialArr.length == 0){
            this.head = null;
            this.tail = null;
            return;
        }

        this.head = new Node(initialArr[0]);
        Node iterator = this.head;

        for (int i = 1; i < initialArr.length; i++){
            iterator.next = new Node(initialArr[i]);
            iterator.next.prev = iterator;
            iterator = iterator.next;
        }

        this.tail = iterator;
    }

    public Node at(int index){
        Node iterator = this.head;
        for (int i = 0; i < index; i++){
            if (iterator.next == null) return null;
            iterator = iterator.next;
        }

        return iterator;
    }

    // insert newNode before the first node
    public void preAppend(Node newNode){
        if (head == null) return;

        head.prev = newNode;
        newNode.next = head;
        newNode.prev = null;
        head = newNode;
    }

    // insert newNode at the end of the list
    public void append(Node newNode){
        if (tail == null){
            tail = newNode;
            head = newNode;
        }

        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = null;
        tail = newNode;
    }

    public void addNextNode(Node node, Node newNode){
        Node temp = node.next;
        node.next = newNode;
        newNode.prev = node;
        newNode.next = temp;


        if (node == tail) tail = newNode;
        else temp.prev = newNode;
    }

    // O(1)
    public void popFront(){
        head = head.next;
        head.prev = null;
    }

    // O(1)
    public void pop(){
        tail = tail.prev;
        tail.next = null;
    }

    // O(1)
    public void delete(Node node){
        if (node == tail) pop();
        else if (node == head) popFront();
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void reverse(){
        if (head == null) return;

        Node reverseHead = tail;
        Node iterator = tail.prev;

        Node current = reverseHead;
        while (iterator != null){
            current.next = iterator;
            iterator = iterator.prev;
            if (iterator != null) iterator.next = null;

            current.next.prev = current;
            current = current.next;
        }

        tail = current;
        head = reverseHead;
        reverseHead.prev = null;
    }

    public void printList(){
        Node iterator = head;
        StringBuilder str = new StringBuilder("[");
        while (iterator != null){
            str.append(iterator.data + ", ");
            iterator = iterator.next;
        }

        System.out.println(str.substring(0, str.length() - 2) + "]");
    }

    public void printReverse(){
        Node iterator = tail;
        StringBuilder str = new StringBuilder("[");

        while (iterator != null){
            str.append(iterator.data + ", ");
            iterator = iterator.prev;
        }

        System.out.println(str.substring(0, str.length() -2) + "]");
    }
}
