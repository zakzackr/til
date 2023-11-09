public class Main {

    public static void main(String[] args) {
        SinglyLinkedList numList = new SinglyLinkedList(new int[]{1, 2, 3, 4, 5});
        numList.printList();

        System.out.println(numList.at(3).data);
        System.out.println(numList.findNode(5));

        doubleEvenNumber(numList);

        numList.preappend(new Node(0));
        numList.append(new Node(6));
        
        numList.printList();

        numList.delete(2);
        numList.printList();
    }

    public static void doubleEvenNumber(SinglyLinkedList numList){
        Node head = numList.head;
        Node current = head;
        int idx = 0;

        while (current != null){
            Node iterator = current;
            current = current.next;
            if (idx % 2 == 0){
                iterator.addNewNode(iterator.data * 2);
            }

            idx++;
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

    public void addNewNode(int data){
        Node temp = next;
        Node newNode = new Node(data);
        next = newNode;
        newNode.next = temp;
    }
}

class SinglyLinkedList{
    public Node head;

    public SinglyLinkedList(int[] arr){
        head = (arr.length > 0)? new Node(arr[0]): null;

        Node iterator = head;

        for (int i = 1; i < arr.length; i++){
            iterator.next = new Node(arr[i]);
            iterator = iterator.next;
        }
    }

    // O(n)
    public Node at(int index){
        if (head == null) return null;

        Node iterator = head;

        for (int i = 1; i <= index; i++){
            iterator = iterator.next;
            if (iterator == null) return null;
        }

        return iterator;
    }

    // O(n)
    public int findNode(int data){
        int idx = 0;
        Node iterator = head;
        while (iterator != null){
            if (iterator.data == data) return idx;
            iterator = iterator.next;
            idx++;
        }

        return -1;
    }

    // O(1)
    public void preappend(Node newNode){
        newNode.next = head;
        head = newNode;
    }

    // O(n)
    public void append(Node newNode){
        Node iterator = head;
        while (iterator != null && iterator.next != null){
            iterator = iterator.next;
        }

        iterator.next = newNode;
    }

    public void delete(int idx){
        if (idx == 0){
            head = head.next;
            return;
        }

        Node iterator = head;

        for (int i = 0; i < idx - 1; i++){
            iterator = iterator.next;
            if (iterator == null)  return;
        }

        iterator.next = iterator.next.next;
    }

    public void printList(){
        Node iterator = head;
        while (iterator != null){
            System.out.print(iterator.data + " ");
            iterator = iterator.next;
        }

        System.out.println();
    }
