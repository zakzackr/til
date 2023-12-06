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

    public static void main(String[] args) {
        int[] sortedArr = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        BinaryTree balancedBST = sortedArrayToBST(sortedArr);

        System.out.println(balancedBST.data);
        System.out.println(balancedBST.left.data);
        System.out.println(balancedBST.left.left.data);
        System.out.println(balancedBST.left.left.right.data);
        System.out.println(balancedBST.left.right.data);
        System.out.println(balancedBST.left.right.right.data);

        System.out.println(balancedBST.right.data);
        System.out.println(balancedBST.right.left.data);
        System.out.println(balancedBST.right.left.right.data);
        System.out.println(balancedBST.right.right.data);
        System.out.println(balancedBST.right.right.right.data);
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
