public class Main{
    public static void main(String[] args){
        BinarySearchTree balancedBST = new BinarySearchTree(new int[]{1,2,3,4,5,6,7,8,9,10,11});
        balancedBST.printSorted();
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

    public void printReverseOrder(){
        reverseOrderWalk(this);
        System.out.println();
    }

    public void reverseOrderWalk(BinaryTree root){
        if (root != null){
            reverseOrderWalk(root.right);
            System.out.print(root.data + " ");
            reverseOrderWalk(root.left);
        }
    }
}

class BinarySearchTree{
    public BinaryTree root;

    public BinarySearchTree(int[] sortedArr){
        if (sortedArr.length == 0) this.root = null;
        else this.root = sortedArrToBST(sortedArr, 0, sortedArr.length - 1);
    }

    public static BinaryTree sortedArrToBST(int[] sortedArr, int start, int end){
        if (start == end) return new BinaryTree(sortedArr[start]);

        int mid = (int)Math.floor((start + end) / 2);

        BinaryTree left = null;
        BinaryTree right = null;
        if (start < mid) left = sortedArrToBST(sortedArr, start, mid - 1);
        if (mid < end) right = sortedArrToBST(sortedArr, mid + 1, end);

        BinaryTree root = new BinaryTree(sortedArr[mid], left, right);
        return root;
    }

    public void printSorted(){
        root.printReverseOrder();
    }
}


