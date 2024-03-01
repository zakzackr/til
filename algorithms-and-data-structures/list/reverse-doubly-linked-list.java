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
            this.head = null;
            this.tail = null;
            return;
        }

        this.head = new Node(arr[0]);
        Node iterator = this.head;
        for (int i = 1; i < arr.length; i++){
            iterator.next = new Node(arr[i]);
            iterator.next.prev = iterator;
            iterator = iterator.next;
        }

        this.tail = iterator;
    }

    public Node at(int index){
        if (this.head == null) return null;
        Node iterator = this.head;
        for (int i = 0; i < index; i++){
            iterator = iterator.next;
            if (iterator == null) return null;
        }

        return iterator;
    }

    public Node find(int key){
        if (this.head == null) return null;
        
        Node iterator = this.head;
        while (iterator != null){
            if (iterator.data == key) return iterator;
            iterator = iterator.next;
        }

        return null;
    }

    public void printList(){
        Node iterator = this.head;
        String str = "";
        while(iterator != null){
            str += iterator.data + " ";
            iterator = iterator.next;
        }
        System.out.println("[" + str + "]");
    }

    public void printInReverse(){
        Node iterator = this.tail;
        while (iterator != null){
            System.out.print(iterator.data + " ");
            iterator = iterator.prev;
        }

        System.out.println();
    }

    public void reverse(){
        Node reverse = this.tail;
        Node iterator = this.tail.prev;  // 末尾から辿っていく
        Node currentNode = reverse;  // 先頭からリストを連結していく

        while (iterator != null){
            currentNode.next = iterator;
            iterator = iterator.prev;

            // if (iterator != null) iterator.next = null;

            currentNode.next.prev = currentNode;
            currentNode = currentNode.next;
        }

        this.head = reverse;
        this.head.prev = null;
        this.tail = currentNode;
        this.tail.next = null;
    }
}

class Main{
    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {};
        DoublyLinkedList numList1 = new DoublyLinkedList(arr1);
        DoublyLinkedList numList2 = new DoublyLinkedList(arr2);

        numList1.printList();
        numList1.printInReverse();
        numList1.reverse();
        numList1.printList();
    }
}
