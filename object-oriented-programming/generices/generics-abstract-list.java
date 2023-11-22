import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenericsArrayList<Integer> integerArrList = new GenericsArrayList<>(new Integer[]{1, 2, 3, 4, 5});
        integerArrList.printList();  // 1 2 3 4 5
        integerArrList.printReverseList();  // 5 4 3 2 1
        integerArrList.add(6);
        integerArrList.add(new Integer[]{7, 8});
        integerArrList.printList();  // 1 2 3 4 5 6 7 8
        integerArrList.printReverseList();  // 8 7 6 5 4 3 2 1
        integerArrList.removeAt(0);
        integerArrList.removeAllAt(5);
        integerArrList.printList();  // 2 3 4 5 6
        integerArrList.printReverseList();  // 6 5 4 3 2

        System.out.println(integerArrList.getOriginalList()[0]);  // 1

        GenericAbstractList list1 = integerArrList.subList(0, 3);
        list1.printList();  // 2 3 4
        GenericAbstractList list2 = integerArrList.subList(3);
        list2.printList();  // 5 6

        System.out.println();

        GenericsLinkedList<Integer> integerLinkedList = new GenericsLinkedList<>(new Integer[]{1, 2, 3, 4, 5});
        integerLinkedList.printList();  // 1 2 3 4 5
        integerLinkedList.printReverseList();  // 5 4 3 2 1
        integerLinkedList.add(6);
        integerLinkedList.add(new Integer[]{7, 8});
        integerLinkedList.printList();  // 1 2 3 4 5 6 7 8
        integerLinkedList.printReverseList();  // 8 7 6 5 4 3 2 1
        integerLinkedList.removeAt(0);
        integerLinkedList.removeAllAt(5);
        integerLinkedList.printList();  // 2 3 4 5 6
        integerLinkedList.printReverseList();  // 6 5 4 3 2

        System.out.println(integerLinkedList.getOriginalList()[0]);  // 1

        GenericAbstractList list3 = integerLinkedList.subList(0, 3);
        list3.printList();  // 2 3 4
        GenericAbstractList list4 = integerLinkedList.subList(3);
        list4.printList();  // 5 6
    }
}

abstract class GenericAbstractList<E>{
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
    public abstract void add(E[] elements);
    public abstract E pop();
    public abstract void addAt(int position, E element);
    public abstract void addAt(int position, E[] elements);
    public abstract E removeAt(int position);
    public abstract void removeAllAt(int start);
    public abstract void removeAllAt(int start, int end);
    public abstract GenericAbstractList<E> subList(int start);
    public abstract GenericAbstractList<E> subList(int start, int end);
    public abstract void printList();
    public abstract void printReverseList();

}

class GenericsArrayList<E> extends GenericAbstractList<E>{
    private ArrayList<E> dArr;

    public GenericsArrayList(){
        super();
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

    public void add(E[] elements){
        for (E e: elements){
            dArr.add(e);
        }
    }
    public E pop(){
        return dArr.remove(dArr.size() - 1);
    }

    public void addAt(int position, E element){
        dArr.add(position, element);
    }

    public void addAt(int position, E[] elements){
        for (E e: elements){
            dArr.add(position++, e);
        }
    }

    public E removeAt(int position){
        return dArr.remove(position);
    }

    public void removeAllAt(int start){
//        for (int i = dArr.size() - 1; i >= start; i--){
//            dArr.remove(i);
//        }

        dArr.subList(start, dArr.size()).clear();
    }



    public void removeAllAt(int start, int end){
//        for (int i = end - 1; i >= start; i--){
//            dArr.remove(i);
//        }

        dArr.subList(start, end).clear();

    }

    public GenericAbstractList<E> subList(int start){
        List<E> sublist = dArr.subList(start, dArr.size());
        E[] arr = (E[])sublist.toArray(new Object[sublist.size()]);

        return new GenericsArrayList<>(arr);
    }

    public GenericAbstractList<E> subList(int start, int end){
        List<E> sublist = dArr.subList(start, end);
        E[] arr = (E[])sublist.toArray(new Object[sublist.size()]);

        return new GenericsArrayList<>(arr);
    }

    public void printList(){
        for (int i = 0; i < dArr.size(); i++){
            System.out.print(dArr.get(i) + " ");
        }
        System.out.println();
    }

    public void printReverseList(){
        for (int i = dArr.size() - 1; i >= 0; i--){
            System.out.print(dArr.get(i) + " ");
        }
        System.out.println();
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

    public void add(E[] elements){
        for (E e: elements){
            add(e);
        }
    }

    public E pop(){
        Node<E> deleted = tail;
        tail = tail.prev;

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

    public void addAt(int position, E[] elements){
        if (tail == at(position)){
            add(elements);
        }

        Node<E> node = at(position - 1);
        Node<E> temp = node.next;

        for (E e: elements){
            node.next = new Node(e);
            node.next.prev = node;
            node = node.next;
        }

        node.next = temp;
        temp.prev = node;
    }
    public E removeAt(int position){
        Node<E> deleted = at(position);

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
        Node<E> startNode = at(start - 1);
        if (startNode == null) return;
        startNode.next = null;
        tail = startNode;
    }

    public void removeAllAt(int start, int end){
        if (start > end || start < 0) {
            return;
        }

        Node<E> startNode = at(start - 1);
        Node<E> endNode = at(end);

        startNode.next = endNode;
        endNode.prev = startNode;
    }

    public GenericAbstractList<E> subList(int start){
        Node<E> startNode = at(start);
        ArrayList<E> dArr = new ArrayList<>();

        while (startNode != null){
            dArr.add(startNode.data);
            startNode = startNode.next;
        }

        return new GenericsLinkedList<>((E[])dArr.toArray(new Object[dArr.size()]));
    }

    public GenericAbstractList<E> subList(int start, int end){
        Node<E> startNode = at(start);
        Node<E> endNode = at(end);
        ArrayList<E> dArr = new ArrayList<>();

        while (startNode != endNode){
            dArr.add(startNode.data);
            startNode = startNode.next;
        }

        return new GenericsLinkedList<>((E[])dArr.toArray(new Object[dArr.size()]));
    }
    public void printList(){
        Node<E> current = head;

        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public void printReverseList(){
        Node<E> current = tail;

        while (current != null){
            System.out.print(current.data + " ");
            current = current.prev;
        }

        System.out.println();
    }
}



