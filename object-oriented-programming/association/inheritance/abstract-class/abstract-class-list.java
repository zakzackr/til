import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AbstractListInteger arrList = new IntegerArrayList(new int[]{2, 4, 8, 10, 18});
        test(arrList);
        System.out.println();
        AbstractListInteger linkedList = new IntegerLinkedList(new int[]{2, 4, 8, 10, 18});
        test(linkedList);
    }

    public static void test(AbstractListInteger list){
        printList(list);
        list.add(20);
        list.add(new int[]{22, 24});
        list.addAt(2, 6);
        list.addAt(5, new int[]{12, 14, 16});
        printList(list);
        list.remove();
        list.removeAt(0);
        list.removeAllAt(9);
        printList(list);
        list.removeAllAt(5, 7);
        printList(list);

        AbstractListInteger list1 = list.subList(5);
        printList(list1);
        AbstractListInteger list2 = list.subList(0,5);
        printList(list2);
    }

    public static void printList(AbstractListInteger list){
        list.printList();
        list.printReverse();
    }
}

abstract class AbstractListInteger{
    protected int[] initialList;

    public AbstractListInteger(){
        this.initialList = new int[0];
    }

    public AbstractListInteger(int[] arr){
        this.initialList = arr;
    }

    public int[] getOriginalList(){
        return this.initialList;
    }

    public abstract int get(int position);
    public abstract void add(int element);
    public abstract void add(int[] elements);
    public abstract void addAt(int position, int element);
    public abstract void addAt(int position, int[] elements);
    public abstract int remove();
    public abstract int removeAt(int position);
    public abstract void removeAllAt(int start);
    public abstract void removeAllAt(int start, int end);
    public abstract AbstractListInteger subList(int start);
    public abstract AbstractListInteger subList(int start, int end);
    public abstract void printList();
    public abstract void printReverse();

    public static ArrayList<Integer> toArrayList(int[] arr){
        ArrayList<Integer> output = new ArrayList<>();
        for (int num: arr){
            output.add(num);
        }

        return output;
    }

    public static int[] toIntArr(List<Integer> dArr){
        int[] output = new int[dArr.size()];
        for (int i = 0; i < dArr.size(); i++){
            output[i] = dArr.get(i);
        }

        return output;
    }
}

class IntegerArrayList extends AbstractListInteger{
    private ArrayList<Integer> dArr;

    public IntegerArrayList(){
        super();
        dArr = new ArrayList<>();
    }

    public IntegerArrayList(int[] arr){
        super(arr);
        dArr = toArrayList(arr);
    }

    public int get(int position){
        return dArr.get(position);
    }

    public void add(int element) {
        dArr.add(element);
    }

    public void add(int[] elements){
        for (int e: elements){
            dArr.add(e);
        }
    }

    public void addAt(int position, int element){
        dArr.add(position, element);
    }

    public void addAt(int position, int[] elements){
        for (int e: elements){
            dArr.add(position, e);
            position++;
        }
    }

    public int remove(){
        return dArr.remove(dArr.size() - 1);
    }

    public int removeAt(int position){
        return dArr.remove(position);
    }

    public void removeAllAt(int start){
        for (int i = start; i < dArr.size(); i++){
            dArr.remove(start);
        }
    }

    public void removeAllAt(int start, int end){
        for (int i = start; i < end; i++){
            dArr.remove(start);
        }
    }

    // Polymorphism
    public AbstractListInteger subList(int start){
        List<Integer> newDArr = dArr.subList(start, dArr.size());
        return new IntegerArrayList(toIntArr(newDArr));

    }

    public AbstractListInteger subList(int start, int end){
        List<Integer> newDArr = dArr.subList(start, end);
        return new IntegerArrayList(toIntArr(newDArr));
    }

    public void printList(){
        System.out.print("[");
        for (int i = 0; i < dArr.size(); i++){
            System.out.print(dArr.get(i) + " ");
        }
        System.out.println("]");
    }

    public void printReverse(){
        System.out.print("[");
        for (int i = dArr.size() - 1; i >= 0; i--){
            System.out.print(dArr.get(i) + " ");
        }
        System.out.println("]");
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
    private Node head;
    private Node tail;

    public IntegerLinkedList(){
        super();
    };

    public IntegerLinkedList(int[] arr){
        if (arr.length == 0) return;
        this.head = new Node(arr[0]);

        Node iterator = this.head;
        for (int i = 1; i < arr.length; i++){
            Node newNode = new Node(arr[i]);
            iterator.next = newNode;
            newNode.prev = iterator;
            iterator = newNode;
        }

        tail = iterator;
    }

    public Node at(int position){
        Node iterator = head;

        for (int i = 0; i < position; i++){
            if (iterator.next == null) return null;
            iterator = iterator.next;
        }

        return iterator;
    }

    public int get(int position){
        Node node = at(position);
        if (node == null) return Integer.MIN_VALUE;
        return node.data;
    }

    public void add(int element){
        if (tail == null){
            tail = new Node(element);
            head = tail;
        }
        else {
            tail.next= new Node(element);
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    public void add(int[] elements){
        Node iterator = tail;  // for now, not considering the case when tail == null
        for (int e: elements){
            iterator.next = new Node(e);
            iterator.next.prev = iterator;
            iterator = iterator.next;
        }

        tail = iterator;
    }

    public void addAt(int position, int element){
        if (tail == at(position)) {
            add(element); 
            return;
        }

        Node node = at(position - 1);
        Node temp = node.next;
        Node newNode = new Node(element);
        node.next = newNode;
        node.next.prev = node;
        newNode.next = temp;
        temp.prev = newNode;
    }

    public void addAt(int position, int[] elements){
        if (tail == at(position)) {
            add(elements);  
            return;
        }

        Node node = at(position - 1);
        Node temp = node.next;
        Node iterator = node;

        for (int e: elements){
            Node newNode = new Node(e);
            iterator.next = newNode;
            newNode.prev = iterator;
            iterator = newNode;
        }

        iterator.next = temp;
        temp.prev = iterator;
    }

    public int remove(){
        Node deleted = tail;
        tail = tail.prev;
        tail.next = null;

        return deleted.data;
    }

    public int removeAt(int position){
        Node deleted = at(position);

        if (deleted == head){
            head = head.next;
            head.prev = null;

        } else {
            deleted.prev.next = deleted.next;
            deleted.next.prev = deleted.prev;
        }

        return deleted.data;
    }

    public void removeAllAt(int start){
        Node startNode = at(start - 1);
        startNode.next = null;
        tail = startNode;
    }

    public void removeAllAt(int start, int end){
        if (start > end || start < 0) {
            return;
        }

        Node startNode = at(start - 1);
        Node endNode = at(end);

        startNode.next = endNode;
        endNode.prev = startNode;
    }

    // Polymorphism
    public AbstractListInteger subList(int start){
        Node current = at(start);
        ArrayList<Integer> subList = new ArrayList<>();

        while (current != null){
            subList.add(current.data);
            current = current.next;
        }

        int[] subArr = toIntArr(subList);
        return new IntegerLinkedList(subArr);
    }

    public AbstractListInteger subList(int start, int end){
        Node startNode = at(start);
        Node endNode = at(end);

        ArrayList<Integer> subList = new ArrayList<>();

        while (startNode != endNode){
            subList.add(startNode.data);
            startNode = startNode.next;
        }

        int[] subArr = toIntArr(subList);
        return new IntegerLinkedList(subArr);
    }

    public void printList(){
        Node iterator = head;

        System.out.print("[");
        while (iterator != null){
            System.out.print(iterator.data + " ");
            iterator = iterator.next;
        }
        System.out.println("]");
    }

    public void printReverse(){
        Node iterator = tail;

        System.out.print("[");
        while (iterator != null){
            System.out.print(iterator.data + " ");
            iterator = iterator.prev;
        }
        System.out.println("]");
    }
}
