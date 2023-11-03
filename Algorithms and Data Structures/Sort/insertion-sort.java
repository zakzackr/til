// Time Complexity: O(n ^ 2) in worst case, O(n) when the original arr is already sorted
// Space Complexity: O(1) because selectionSort is in-place algorithm.

public class Main {

    public static void main(String[] args) {
        printArr(insertionSort(new int[]{2, 3, 5, 1, 4}));
    }


    public static int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            
            for (int j = i -1; j >= 0; j--){
                if (arr[j] <= arr[j + 1]) break;
                else {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    public static void printArr(int[] arr){
        for (int num: arr){
            System.out.println(num);
        }
    }
}
