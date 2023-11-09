// Time Complexity: O(nlogn) 
// Space Complexity: O(n) because it creates new ArrayList to store the result

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // when the number of the elements is odd
        System.out.println((mergeSort(new ArrayList<Integer>(Arrays.asList(2, 3, 5, 4, 1)))));
        // when the number of the elements is even
        System.out.println((mergeSort(new ArrayList<Integer>(Arrays.asList(2, 6, 3, 5, 4, 1)))));
    }


    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr){
        return mergeSortHelper(arr, 0, arr.size() - 1);
    }

    public static ArrayList<Integer> mergeSortHelper(ArrayList<Integer> arr, int start, int end){
        if (start == end) return new ArrayList<Integer>(Arrays.asList(arr.get(start)));

        int middle = (start + end) / 2;

        ArrayList<Integer> left = mergeSortHelper(arr, start, middle);
        ArrayList<Integer> right = mergeSortHelper(arr, middle + 1, end);

        left.add(Integer.MAX_VALUE);
        right.add(Integer.MAX_VALUE);
        int len = left.size() + right.size();
        int li = 0;
        int ri = 0;

        ArrayList<Integer> output = new ArrayList<>();

        while (li + ri < len - 2){
            if (left.get(li) <= right.get(ri)){
                output.add(left.get(li++));
            } else {
                output.add(right.get(ri++));
            }
        }

        return output;
    }
}
