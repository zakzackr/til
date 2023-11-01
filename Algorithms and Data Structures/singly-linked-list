public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{35, 23, 546, 67, 86, 234, 56, 767, 34, 1, 98, 78, 555};
        SinglyLinkedList numList = new SinglyLinkedList(arr);

        // testing methods in SinglyLinkedList class
        numList.preAppend(new Node(33));
        numList.append(new Node(55));

        System.out.println(numList.at(3).data);
        numList.printList();

        numList.delete(3);
        numList.printList();

        System.out.println(numList.findNode(1000));
        System.out.println(numList.findNode(23));

        // testing addNewNode method in Node class
        // double the element with odd number as index and insert it after the element
        int index = 0;
        Node current = numList.head;
        while (current != null){
            Node iterator = current;
            current = current.next;
            if (index % 2 == 0){
                iterator.addNextNode(new Node(iterator.data * 2));
            }

            index++;
        }

        numList.printList();
    }
}

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }

    public void addNextNode(Node newNode){
        Node temp = next;
        next = newNode;
        newNode.next = temp;
    }
}

class SinglyLinkedList{
    public Node head;

    public SinglyLinkedList(int[] arr){
        this.head = arr.length > 0? new Node(arr[0]): null;

        Node current = this.head;
        for (int i = 1; i < arr.length; i++){
            current.next = new Node(arr[i]);
            current = current.next;
        }
    }

    public Node at(int index){
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
            if (current == null) return null;
        }

        return current;
    }

    public int findNode(int key){
        Node current = head;
        int idx = 0;

        while (current != null){
            if (current.data == key) return idx;
            current = current.next;
            idx++;
        }

        return -1;
    }

    public void preAppend(Node newNode){
        newNode.next = head;
        head = newNode;
    }

    public void append(Node newNode){
        Node current = head;

        while (current.next != null){
            current = current.next;
        }

        current.next = newNode;
    }

    // O(1)
    public void popFront(){
        head = head.next;
    }

    public void delete(int index){
        if (index == 0){
            popFront();
            return;
        }

        Node current = head;

        for (int i = 0; i < index - 1; i++){
            current = current.next;
            if (current == null) return;
        }

        current.next = current.next.next;
    }

    public void printList(){
        Node current = head;
        System.out.print("[");

        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println("]");
    }
}
