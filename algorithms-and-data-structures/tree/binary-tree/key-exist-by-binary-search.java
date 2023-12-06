public class Main {
    public static BinaryTree sortedArrayToBSTHelper(int[] arr, int start, int end){
        if (start == end) return new BinaryTree(arr[start]);

        int mid = (int)Math.floor((start + end) / 2);

        BinaryTree left = null;
        if (start < mid) left = sortedArrayToBSTHelper(arr, start, mid - 1);

        BinaryTree right = null;
        if (mid < end) right = sortedArrayToBSTHelper(arr, mid + 1, end);

        BinaryTree root = new BinaryTree(arr[mid], left, right);
        return root;
    }

    public static BinaryTree sortedArrayToBST(int[] arr){
        if (arr.length == 0) return null;
        return sortedArrayToBSTHelper(arr, 0, arr.length - 1);
    }

    public static boolean keyExist(int key, BinaryTree bst){
        if (bst == null) return false;
        if (key == bst.data) return true;

        bst = (key < bst.data)? bst.left: bst.right;
        return keyExist(key, bst);
    }
    
    public static void main(String[] args) {
        int[] sortedArr = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        BinaryTree balancedBST = sortedArrayToBST(sortedArr);

        System.out.println(keyExist(1, balancedBST));
        System.out.println(keyExist(2, balancedBST));
        System.out.println(keyExist(3, balancedBST));
        System.out.println(keyExist(4, balancedBST));
        System.out.println(keyExist(5, balancedBST));
        System.out.println(keyExist(6, balancedBST));
        System.out.println(keyExist(7, balancedBST));
        System.out.println(keyExist(8, balancedBST));
        System.out.println(keyExist(9, balancedBST));
        System.out.println(keyExist(10, balancedBST));
        System.out.println(keyExist(11, balancedBST));
        System.out.println(keyExist(12, balancedBST));
    }
}

class BinaryTree{
    public int data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int data){
        this.data = data;
    }

    public BinaryTree(int data, BinaryTree left, BinaryTree right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
