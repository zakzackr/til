import java.util.Arrays;

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

    public BinarySearchTree(int[] arr){
        Arrays.sort(arr);
        this.root = this.sortedArrToBST(arr, 0, arr.length - 1);
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
        if (root == null) return;
        root.printInOrder();
    }

    public void insert(int data){
        BinaryTree iterator = root;

        while (iterator != null){
            if (iterator.left == null && data < iterator.data) iterator.left = new BinaryTree(data);
            else if (iterator.right == null && data > iterator.data) iterator.right = new BinaryTree(data);
            iterator = (data < iterator.data)? iterator.left: iterator.right;
        }
    }

    public boolean keyExist(int key){
        BinaryTree iterator = root;
        while (iterator != null){
            if (key == iterator.data) return true;
            iterator = (key < iterator.data)? iterator.left: iterator.right;
        }

        return false;
    }

    public BinaryTree search(int key){
        BinaryTree iterator = root;

        while (iterator != null){
            if (key == iterator.data) return iterator;
            iterator = (key < iterator.data)? iterator.left: iterator.right;
        }

        return null;
    }

    public void transtplant(BinaryTree nodeParent, BinaryTree node, BinaryTree target){
        // nodeParentがnullの場合、つまりrootノードを移植する場合は、root自体をtargetに置き換える。
        if (nodeParent == null) root = target;
            // 左の子ノードを移植する場合
        else if (nodeParent.left == node) nodeParent.left = target;
            // 右の子ノードを移植する場合
        else nodeParent.right = target;
    }

    public void deleteNode(int key){
        // 木が空の場合
        if (root == null) return;
        // keyと等しい値を持つnodeをnode変数に格納
        BinaryTree node = search(key);
        // keyと等しい値を持つnodeがbst内に存在しないならexit
        if (!keyExist(key)) return;

        BinaryTree parent = findParent(node);

        // case 1: ノードNが葉ノード
        // 親ノードからnodeへの参照をnullに変更してnodeを削除します。
        if (node.left == null && node.right == null){
            if (parent.left == node) parent.left = null;
            else parent.right = null;
        }

        // case 2: ノードNの左が空
        if (node.left == null) transtplant(parent, node, node.right);
            // case 3: ノードNの右が空
        else if (node.right == null) transtplant(parent, node, node.left);
            // case 4: ノードNが2つの子を持っている場合
        else {
            BinaryTree successor = findSuccessor(node);
            BinaryTree successorP = findParent(successor);
            // case 4 後続ノードSがすぐ右側にいる場合 : この場合、ノードNが後続ノードSの親になっているため、case4は必要ありません。単純にNの親であるPの部分木とSを移植すればokです。
            // 特別なケース (case 4) 後続ノードSがすぐ右側にいない場合 : この場合、後続Sの親も変更しなければいけません。
            if (node.right != successor){
                // 後続ノードSをSの右部分木で移植します。Sをアップデートする。
                transtplant(successorP, successor, successor.right);
                // Sの右側はノードNの右側になっている必要があります。
                successor.right = node.right;
            }
            // ノードNを後続Sで移植します。Sの左部分木をノードNの左部分木にします。
            transtplant(parent, node, successor);
            successor.left = node.left;
        }
    }

    public BinaryTree findParent(BinaryTree node){
        BinaryTree iterator = root;
        BinaryTree parent = null;

        while (iterator != node){
            parent = iterator;
            iterator = (node.data < iterator.data)? iterator.left: iterator.right;
        }

        return parent;
    }


    public BinaryTree findSuccessor(BinaryTree node){
        BinaryTree targetNode = node;
        if (targetNode == null) return null;
        // 後続ノードがtargetNodeの右の部分木にある時
        if (targetNode.right != null) return minimumNode(targetNode.right);

        // 後続ノードがtargetNodeの右の部分木にない時
        BinaryTree successor = null;
        BinaryTree iterator = root;

        // 根からたどっていく
        while (iterator != null){
            if (targetNode.data == iterator.data) return successor;
            if (targetNode.data < iterator.data && (successor == null || iterator.data < successor.data)) successor = iterator;

            iterator = (targetNode.data < iterator.data)? iterator.left: iterator.right;
        }

        return successor;
    }

    public BinaryTree minimumNode(BinaryTree node){
        BinaryTree iterator = node;

        while (iterator != null && iterator.left != null){
            iterator = iterator.left;
        }

        return iterator;
    }

}

public class Main{
    public static void main(String[] args){
        BinarySearchTree balancedBST = new BinarySearchTree(new int[]{4,43,36,46,32,7,97,95,34,8,96,35,85,1010,232});
        balancedBST.printSorted();
        balancedBST.deleteNode(46);
        balancedBST.printSorted();
        balancedBST.deleteNode(7);
        balancedBST.printSorted();
        balancedBST.deleteNode(4);
        balancedBST.printSorted();
        balancedBST.deleteNode(1010);
        balancedBST.printSorted();
        // 存在しない0をdeleteNodeします。
        balancedBST.deleteNode(0);
        balancedBST.printSorted();
    }
}


