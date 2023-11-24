import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GenericAbstractList<Integer> arrayList = new GenericsArrayList<>(new Integer[]{1, 2, 3, 4, 5});
        dequePrint(arrayList);
        GenericAbstractList<Integer> linkedList = new GenericsLinkedList<>(new Integer[]{1, 2, 3, 4, 5});
        dequePrint(linkedList);

        GenericAbstractList<Integer> arrayList2 = new GenericsArrayList<>();
        arrayList2.push(2);
        arrayList2.push(3);
        arrayList2.push(4);
        arrayList2.addFirst(1);
        dequePrint(arrayList2);

        GenericAbstractList<Integer> linkedList2 = new GenericsLinkedList<>();
        linkedList2.push(2);
        linkedList2.push(3);
        linkedList2.push(4);
        linkedList2.addFirst(1);
        dequePrint(linkedList2);
    }

    public static void dequePrint(GenericAbstractList list){
        while (list.peekFront() != null){
            System.out.print(list.popFront() + " ");
            if (list.peekLast() != null) {
                System.out.print(list.popLast() + " ");
            }
        }

        System.out.println();
    }
}

interface Queue<E> {
    public abstract E peekFront();
    public abstract E popFront();
    public abstract void push(E element);
}

interface Stack<E> {
    public abstract E peekLast();
    public abstract E popLast();
    public abstract void push(E element);
}

interface Deque<E> extends Queue<E>, Stack<E>{
    public abstract void addFirst(E element);
}

abstract class GenericAbstractList<E> implements Deque<E>{
    protected E[] initialList;

    public GenericAbstractList(){}

    public GenericAbstractList(E[] arr){
        this.initialList = arr;
    }

    public E[] getOriginalList(){
        return initialList;
    }

    public abstract E get(int position);
    public abstract void add(E element);
    public abstract E pop();
    public abstract void addAt(int position, E element);
    public abstract E removeAt(int position);
    public abstract int getSize();
}

class GenericsArrayList<E> extends GenericAbstractList<E>{
    private ArrayList<E> dArr;

    public GenericsArrayList(){
        super();
        this.dArr = new ArrayList<>();
    }

    public GenericsArrayList(E[] arr){
        super(arr);

        this.dArr = new ArrayList<>(Arrays.asList(arr));
    }

    public E get(int position){
        return dArr.get(position);
    }

    public void add(E element){
        dArr.add(element);
    }

    public E pop(){
        return dArr.remove(dArr.size() - 1);
    }

    public void addAt(int position, E element){
        dArr.add(position, element);
    }

    public E removeAt(int position){
        return dArr.remove(position);
    }

    public int getSize(){
        return dArr.size();
    }

    // implementing abstract methods from interfaces
    public E peekFront(){
        if (getSize() == 0) return null;
        return dArr.get(0);
    }

    public E popFront(){
        if (dArr.size() == 0) return null;
        return dArr.remove(0);
    }

    public void push(E element){
        add(element);
    }

    public E peekLast(){
        if (dArr.size() == 0) return null;
        return dArr.get(dArr.size() - 1);
    }
    public E popLast(){
        return dArr.remove(dArr.size() - 1);
    }

    public void addFirst(E element){
        dArr.add(0, element);
    }
}

class Node<E>{
    public E data;
    public Node next;
    public Node prev;

    public Node(E data){
        this.data = data;
    }
}

class GenericsLinkedList<E> extends GenericAbstractList<E>{
    private Node<E> head;
    private Node<E> tail;

    public GenericsLinkedList(){
        super();
    }

    public GenericsLinkedList(E[] arr){
        super(arr);

        if (arr.length == 0) return;

        this.head = new Node(arr[0]);
        Node<E> current = this.head;

        for (int i = 1; i < arr.length; i++){
            current.next = new Node(arr[i]);
            current.next.prev = current;
            current = current.next;
        }

        this.tail = current;
    }

    public Node<E> at(int position){
        Node<E> current = head;
        for (int i = 0; i < position; i++){
            if (current.next == null) return null;
            current = current.next;
        }

        return current;
    }

    public E get(int position){
//        Node<E> current = head;
//
//        for (int i = 0; i < position; i++){
//            if (current.next == null) return null;
//            current = current.next;
//        }

        Node<E> node = at(position);

        return (node != null)? node.data: null;
    }
    public void add(E element){
        if (tail == null){
            tail = new Node(element);
            head = tail;
        } else {
            tail.next = new Node(element);
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    public E pop(){
        if (tail == null) return null;

        Node<E> deleted = tail;
        tail = tail.prev;
        if (tail == null) head = null;
        else tail.next = null;

        return deleted.data;
    }

    public void addAt(int position, E element){
        Node<E> node = at(position - 1);
        if (node != null){
            Node<E> newNode = new Node(element);
            Node<E> temp = node.next;
            node.next = newNode;
            newNode.prev = node;
            newNode.next = temp;
            temp.prev = newNode;
        }
    }

    public E removeAt(int position){
        Node<E> deleted = at(position);

        if (deleted == head){
            head = head.next;
            if (head == null) tail = null;
            else head.prev = null;
        } else {
            deleted.prev.next = deleted.next;
            deleted.next.prev = deleted.prev;
        }

        return deleted.data;
    }

    public int getSize(){
        if (head == null) return 0;

        Node<E> current = head;
        int size = 0;

        while (current != null){
            current = current.next;
            size++;
        }

        return size;
    }

    public E peekFront(){
        if (head == null) return null;
        return head.data;
    }
    public E popFront(){
        if (head == null) return null;
        return removeAt(0);
    }

    public void push(E element){
        add(element);
    }

    public E peekLast(){
        if (tail == null) return null;
        return tail.data;
    }

    public E popLast(){
        return pop();
    }

    public void addFirst(E element){
        Node<E> temp = head;
        head = new Node(element);
        head.next = temp;
    }
}



