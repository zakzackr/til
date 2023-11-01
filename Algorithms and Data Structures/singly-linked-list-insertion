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

public class Main {

    public static void main(String[] args){
        System.out.println((MergeSort.mergeSort(new int[]{1,3,5,6,4,2})[2]));

        int[] arr = new int[]{35,23,546,67,86,234,56,767,34,1,98,78,555};
        SinglyLinkedList numList = new SinglyLinkedList(arr);

        int count = 0;
        Node current = numList.head;
        while(current != null){
        
// instead of this code block, I made addNextNode method in Node class
//            if (count % 2 == 0){
//                Node temp = current.next;
//                Node doubleNode = new Node(current.data * 2);
//                current.next = doubleNode;
//                doubleNode.next = temp;
//                current = temp;
//            } else {
//                current = current.next;
//            }

            Node iterator = current;
            current = current.next;
            if (count % 2 == 0) iterator.addNextNode(new Node(iterator.data * 2));
            count++;
        }

        numList.printList();
    }
}
