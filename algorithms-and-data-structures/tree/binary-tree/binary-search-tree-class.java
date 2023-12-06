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
        BinaryTree iterator = bst;

        while (iterator != null){
            if (iterator.data == key) return true;
            iterator = (key < iterator.data)? iterator.left: iterator.right;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] sortedArr = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        BinarySearchTree bst = new BinarySearchTree(sortedArr);

        System.out.println(bst.keyExist(6));
        System.out.println(bst.search(6).data);
        System.out.println(bst.keyExist(2));
        System.out.println(bst.search(2).data);
        System.out.println(bst.keyExist(34));
        System.out.println(bst.search(34));
    }
}

class BinarySearchTree{
    public BinaryTree root;

    public BinarySearchTree(int[] sortedArr){
        if (sortedArr.length == 0) return;
        this.root = sortedArrToBST(sortedArr, 0, sortedArr.length - 1);
    }

    public static BinaryTree sortedArrToBST(int[] sortedArr, int start, int end){
        if (sortedArr.length == 0) return null;
        if (start == end) return new BinaryTree(sortedArr[start]);

        int mid = (int)Math.floor((start + end) / 2);

        BinaryTree left = null;
        if (start < mid) left = sortedArrToBST(sortedArr, start, mid - 1);

        BinaryTree right = null;
        if (mid < end) right = sortedArrToBST(sortedArr, mid + 1, end);

        BinaryTree root = new BinaryTree(sortedArr[mid], left, right);
        return root;
    }

    public boolean keyExist(int key) {
        BinaryTree iterator = root;
        while (iterator != null) {
            if (iterator.data == key) return true;
            iterator = (key < iterator.data) ? iterator.left : iterator.right;
        }

        return false;
    }

    public BinaryTree search(int key){
        BinaryTree iterator = root;
        while (iterator != null) {
            if (iterator.data == key) return iterator;
            iterator = (key < iterator.data) ? iterator.left : iterator.right;
        }

        return null;
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
