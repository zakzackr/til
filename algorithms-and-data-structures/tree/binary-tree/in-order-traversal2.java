import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{
    public static void main(String[] args){
        ArrayList<Integer> list = RandomContainer.generateRandomList(100);
        BinarySearchTree bst = new BinarySearchTree(list);
        bst.printSorted();
        System.out.println(BinarySearchTree.getMaximumDepth(bst.root));
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

    public void inOrderWalk(BinaryTree root){
        if (root != null){
            inOrderWalk(root.left);
            System.out.print(root.data + " ");
            inOrderWalk(root.right);
        }
    }
}

class BinarySearchTree{
    public BinaryTree root;

    public BinarySearchTree(int[] sortedArr){
        if (sortedArr.length == 0) this.root = null;
        else this.root = sortedArrToBST(sortedArr, 0, sortedArr.length - 1);
    }

    public BinarySearchTree(List<Integer> list){
        this.generateRandomBST(list);
    }

    public static BinaryTree sortedArrToBST(int[] sortedArr, int start, int end){
        if (start == end) return new BinaryTree(sortedArr[start]);

        int mid = (int)Math.floor((start + end) / 2);

        BinaryTree left = null;
        BinaryTree right = null;
        if (start < mid) left = sortedArrToBST(sortedArr, 0, mid - 1);
        if (mid < end) right = sortedArrToBST(sortedArr, mid + 1, end);

        BinaryTree root = new BinaryTree(sortedArr[mid], left, right);
        return root;
    }

    public void generateRandomBST(List<Integer> list){
        if (list.isEmpty()) root = null;
        else {
            Collections.shuffle(list);
            root = new BinaryTree(list.get(0));

            for (int i = 1; i < list.size(); i++){
                insert(list.get(i));
            }
        }
    }

    public void insert(int data){
        BinaryTree current = root;

        while (current != null){
            if (data < current.data && current.left == null) current.left = new BinaryTree(data);
            else if (data > current.data && current.right == null) current.right = new BinaryTree(data);
            current = (data < current.data)? current.left: current.right;
        }
    }

    public static int getMaximumDepth(BinaryTree root){
        if (root == null) return 0;
        int maxLeft = getMaximumDepth(root.left);
        int maxRight = getMaximumDepth(root.right);
        return (maxLeft > maxRight)? maxLeft + 1: maxRight + 1;
    }

    public void printSorted(){
        root.printInOrder();
    }
}

class RandomContainer{
    public static ArrayList<Integer> generateRandomList(int size){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++){
            list.add(i);
        }

        return list;
    }
}

