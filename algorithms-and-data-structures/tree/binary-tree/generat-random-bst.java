import java.util.ArrayList;
import java.util.Collections;

class BinaryTree {
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

    public void inOrderWalk(BinaryTree root){
        if (root != null){
            inOrderWalk(root.left);
            System.out.print(root.data + " ");
            inOrderWalk(root.right);
        }
    }

    public void printInOrder(){
        inOrderWalk(this);
        System.out.println();
    }
}

class BinarySearchTree {
    public BinaryTree root;

    public BinarySearchTree(ArrayList<Integer> list){
        this.generateRandomBST(list);
    }

    public void printSorted(){
        if (root == null) return;
        root.printInOrder();
    }

    public void generateRandomBST(ArrayList<Integer> list) {
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
        BinaryTree iterator = root;

        while (iterator != null){
            if (data < iterator.data && iterator.left == null) iterator.left = new BinaryTree(data);
            else if (data > iterator.data && iterator.right == null) iterator.right = new BinaryTree(data);
            iterator = (data < iterator.data)? iterator.left: iterator.right;
        }
    }

    public static int getMaxDepth(BinaryTree root){
        if (root == null) return 0;
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);

        return (left > right)? left + 1: right + 1;
    }
}

class RandomContainer{
    public static ArrayList<Integer> generateList(int size){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++){
            list.add(i);
        }

        return list;
    }
}

public class Main{
    public static void main(String[] args){
        ArrayList<Integer> list = RandomContainer.generateList(256);
        BinarySearchTree bst = new BinarySearchTree(list);
        bst.printSorted();
        System.out.println("MaxDepth: "  + BinarySearchTree.getMaxDepth(bst.root));
    }
}


