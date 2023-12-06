import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        int[] sortedArr = new int[]{1, 2, 3, 4, 5, 6};
        BinarySearchTree bst = new BinarySearchTree(sortedArr);
        bst.printSorted();

        System.out.println();

        ArrayList<Integer> list = RandomContainer.generateList(256);
        BinarySearchTree balancedBST = new BinarySearchTree(list);
        balancedBST.printSorted();
        System.out.println(16*16);
        System.out.println("MaxDepth: " + BinarySearchTree.maximumDepth(balancedBST.root));

        ArrayList<Integer> list2 = new ArrayList<>();
        BinarySearchTree balancedBST2 = new BinarySearchTree(list2);
        balancedBST2.printSorted();
        System.out.println("MaxDepth: " + BinarySearchTree.maximumDepth(balancedBST2.root));
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

    public void printInOrder(){
        inOrderWalk(this);
        System.out.println();
    }

    public void inOrderWalk(BinaryTree tRoot){
        if (tRoot != null){
            inOrderWalk(tRoot.left);
            System.out.print(tRoot.data +" ");
            inOrderWalk(tRoot.right);
        }
    }
}

class BinarySearchTree{
    public BinaryTree root;

    public BinarySearchTree(int[] sortedArr){
        if (sortedArr.length == 0) return;
        this.root = sortedArrToBST(sortedArr, 0, sortedArr.length - 1);
    }

    public BinarySearchTree(ArrayList<Integer> list){
        this.generateBST(list);
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

    public void generateBST(ArrayList<Integer> list){
        if (list.isEmpty()) root = null;
        else {
            Collections.shuffle(list);  // every combination will be created with the same probability
            root = new BinaryTree(list.get(0));
            for (int i = 1; i < list.size(); i++){
                insert(list.get(i));
            }
        }
    }

    public void insert(int data){
        BinaryTree iterator = root;
        while(iterator != null){
            if(iterator.data > data && iterator.left == null) iterator.left = new BinaryTree(data);
            else if(iterator.data < data && iterator.right == null) iterator.right = new BinaryTree(data);
            iterator = (iterator.data > data)? iterator.left: iterator.right;
        }
    }

    public static int maximumDepth(BinaryTree root){
        if(root == null) return 0;
        int maxLeft = maximumDepth(root.left);
        int maxRight = maximumDepth(root.right);
        return (maxLeft > maxRight)? maxLeft + 1: maxRight + 1;
    }

    public void printSorted(){
        if (root == null) return;
        root.printInOrder();
    }
}

class RandomContainer{
    public static ArrayList<Integer> generateList(int size){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) list.add(i);

        return list;
    }
}


