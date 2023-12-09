import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class Heap{
    public static int left(int i){
        return 2 * i + 1;
    }

    public static int right(int i){
        return 2 * i + 2;
    }

    public static int parent(int i){
        return (int)Math.floor((i - 1) / 2);
    }

    public static void maxHeapify(ArrayList<Integer> list, int i){
        int l = left(i);
        int r = right(i);

        int biggest = i;

        if (l < list.size() && list.get(l) > list.get(biggest)) biggest = l;
        if (r < list.size() && list.get(r) > list.get(biggest)) biggest = r;

        if (biggest != i){
            int temp = list.get(i);
            list.set(i, list.get(biggest));
            list.set(biggest, temp);
            maxHeapify(list, biggest);
        }
    }
}

public class Main{
    public static void main(String[] args){
        ArrayList<Integer> heap1 = new ArrayList<>(Arrays.asList(new Integer[]{2,42,11,30,10,7,6,5,9}));
        System.out.println(heap1);
        Heap.maxHeapify(heap1, 0);
        System.out.println(heap1);

        ArrayList<Integer> heap2 = new ArrayList<>(Arrays.asList(new Integer[]{56,4,51,10,12,5,12,4,6,5}));
        System.out.println(heap2);
        Heap.maxHeapify(heap2,1);
        System.out.println(heap2);
    }
}


