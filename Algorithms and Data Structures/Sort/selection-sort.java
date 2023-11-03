// Time Complexity: O(n ^ 2)
// Space Complexity: O(1) because selectionSort is in-place algorithm.

public class Main {

    public static void main(String[] args) {
        printArr(selectionSort(new int[]{2, 3, 5, 1, 4}));
    }


    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        return arr;
    }

    public static void printArr(int[] arr){
        for (int num: arr){
            System.out.println(num);
        }
    }
}
