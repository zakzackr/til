public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{35,23,546,67,86,234,56,767,34,1,98,78,555};
        DoublyLinkedList numList = new DoublyLinkedList(arr);

        numList.printList();

        numList.preappend(new Node(45));
        System.out.println(numList.head.data);
        numList.printList();

        // 71をappend
        numList.append(new Node(71));
        System.out.println(numList.tail.data);
        numList.printList();

        numList.addNewNode(numList.at(3), new Node(4));
        numList.printList();
        System.out.println(numList.tail.data);

        numList.addNewNode(numList.at(15), new Node(679));
        numList.printList();
        System.out.println(numList.tail.data);

        numList.printReverse();

        numList.printList();

        // pop
        numList.popFront();
        numList.pop();

        numList.printList();
        numList.printReverse();

        // delete node
        System.out.println("Deleting in O(1)");
        numList.delete(numList.at(3));
        numList.delete(numList.at(9));
        numList.delete(numList.at(0));

        numList.printList();
        numList.printReverse();
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

    public DoublyLinkedList(int[] arr){
        if (arr.length == 0){
            head = null;
            tail = null;
        }

        head = new Node(arr[0]);
        Node current = head;

        for (int i = 1; i < arr.length; i++){
            current.next = new Node(arr[i]);
            current.next.prev = current;
            current = current.next;
        }

        tail = current;
    }

    public Node at(int index){
        Node iterator = head;
        for (int i = 0; i < index; i++){
            iterator = iterator.next;
            if (iterator == null) return null;
        }

        return iterator;
    }

    public int find(int data){
        int idx = 0;

        Node current = head;

        while (current != null){
            if (current.data == data) return idx;
            current = current.next;
            idx++;
        }

        return -1;
    }

    public void preappend(Node newNode){
        newNode.next = head;
        newNode.next.prev = newNode;
        newNode.prev = null;
        head = newNode;
    }

    public void append(Node newNode){
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = null;
        tail = newNode;
    }

    public void addNewNode(Node node, Node newNode) {
        Node tempNode = node.next;
        node.next = newNode;
        newNode.prev = node;
        newNode.next = tempNode;

        if (node == tail) tail = newNode;
        else tempNode.prev = newNode;
    }

    public void pop(){
        tail = tail.prev;
        tail.next = null;
    }

    public void popFront(){
        head = head.next;
        head.prev = null;
    }

    public void delete(Node node){
        if (node == tail) pop();
        else if (node == head) popFront();
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }


    public void printList(){
        Node current = head;

        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printReverse(){
        Node current = tail;

        while (current != null){
            System.out.print(current.data + " ");
            current = current.prev;
        }

        System.out.println();
    }
}
