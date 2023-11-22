import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenericsArrayList<Integer> integerArrList = new GenericsArrayList<>(new Integer[]{1, 2, 3, 4, 5});
        integerArrList.printList();  // 1 2 3 4 5
        integerArrList.add(6);
        integerArrList.add(new Integer[]{7, 8});
        integerArrList.printList();  // 1 2 3 4 5 6 7 8
        integerArrList.removeAt(0);
        integerArrList.removeAllAt(5);
        integerArrList.printList();  // 2 3 4 5 6

        GenericAbstractList list1 = integerArrList.subList(0, 3);
        list1.printList();  // 2 3 4 
        GenericAbstractList list2 = integerArrList.subList(3);
        list2.printList();  // 5 6
    }
}

abstract class GenericAbstractList<E>{
    private E[] initialList;

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
}

