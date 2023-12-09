import java.util.ArrayList;
import java.util.Arrays;

class HeapLibrary{
    public static int left(int i){
        return 2 * i + 1;
    }

    public static int right(int i){
        return 2 * i + 2;
    }

    public static int parent(int i){
        return (int)Math.floor((i - 1) / 2);
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

    public static void buildMaxHeap(ArrayList<Integer> list){
        int mid = parent(list.size() - 1);

        for (int i = mid; i >= 0; i--){
            maxHeapify(list, list.size() - 1, i);
        }
    }
}

class PriorityQueue{
    public ArrayList<Integer> maxHeap;

    public PriorityQueue(ArrayList<Integer> list){
        this.maxHeap = new ArrayList<>();
        for (Integer i: list) this.maxHeap.add(i);
        HeapLibrary.buildMaxHeap(this.maxHeap);
    }

    public Integer top(){
        if (maxHeap.isEmpty()) return null;
        return maxHeap.get(0);
    }

    public Integer pop(){
        if (maxHeap.isEmpty()) return null;

        int popped = maxHeap.get(0);
        maxHeap.set(0, maxHeap.get(maxHeap.size() - 1));
        maxHeap.remove(maxHeap.size() - 1);

        HeapLibrary.maxHeapify(maxHeap, maxHeap.size() - 1, 0);

        return popped;
    }

    public void insert(int data){
        maxHeap.add(data);
        int i = maxHeap.size() - 1;
        int parent = HeapLibrary.parent(i);

        while (parent >= 0 && data > maxHeap.get(parent)){
            int temp = maxHeap.get(i);
            maxHeap.set(i, maxHeap.get(parent));
            maxHeap.set(parent, temp);

            i = parent;
            parent = HeapLibrary.parent(i);
        }
    }
}

public class Main{
    public static void main(String[] args){
        ArrayList<Integer> heap1 = new ArrayList<>(Arrays.asList(new Integer[]{2,3,43,2,53,6,75,10}));
        System.out.println(heap1);
        PriorityQueue pq = new PriorityQueue(heap1);
        System.out.println(pq.maxHeap);
        pq.insert(5);
        System.out.println(pq.maxHeap);
        pq.insert(5);
        System.out.println(pq.maxHeap);
        pq.insert(79);
        System.out.println(pq.maxHeap);
        pq.pop();
        System.out.println(pq.maxHeap);
    }
}


