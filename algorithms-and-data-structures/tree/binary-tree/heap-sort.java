// Time Complexity: O(NlogN)
// Space Complexity: O(1)

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

    public static void buildMaxHeap(ArrayList<Integer> list){
        int mid = parent(list.size() - 1);

        for (int i = mid; i >= 0; i--){
            maxHeapify(list, list.size() - 1, i);
        }
    }

    public static void maxHeapify(ArrayList<Integer> list, int heapEnd, int i){
        int l = left(i);
        int r = right(i);

        int biggest = i;

        if (l <= heapEnd && list.get(l) > list.get(biggest)) biggest = l;
        if (r <= heapEnd && list.get(r) > list.get(biggest)) biggest = r;

        if (biggest != i){
            int temp = list.get(i);
            list.set(i, list.get(biggest));
            list.set(biggest, temp);
            maxHeapify(list, heapEnd, biggest);
        }
    }

    public static void heapSort(ArrayList<Integer> list){
        buildMaxHeap(list);
        int heapEnd = list.size() - 1;

        while (heapEnd > 0){
            int temp = list.get(0);
            list.set(0, list.get(heapEnd));
            list.set(heapEnd, temp);

            heapEnd--;
            maxHeapify(list, heapEnd, 0);
        }
    }
}

public class Main{
    public static void main(String[] args){
        ArrayList<Integer> heap1 = new ArrayList<>(Arrays.asList(new Integer[]{2,42,11,30,10,7,6,5,9}));
        System.out.println(heap1);
        Heap.heapSort(heap1);
        System.out.println(heap1);

        ArrayList<Integer> heap2 = new ArrayList<>(Arrays.asList(new Integer[]{56,4,51,10,12,5,12,4,6,5}));
        System.out.println(heap2);
         Heap.heapSort(heap2);
        System.out.println(heap2);
    }
}


