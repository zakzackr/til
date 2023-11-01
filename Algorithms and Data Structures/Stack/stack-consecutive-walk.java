import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // [5,3,2]
        printArr(consecutiveWalk(new int[]{3,4,20,45,56,6,4,3,5,3,2}));
        // [64,3,0,-34,-54]
        printArr(consecutiveWalk(new int[]{4,5,4,2,4,3646,34,64,3,0,-34,-54}));
        // [4]
        printArr(consecutiveWalk(new int[]{4,5,4,2,4,3646,34,64,3,0,-34,-54,4}));
    }

    public static int[] consecutiveWalk(int[] arr){
        Stack stack = new Stack();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++){
            if (arr[i] >= stack.peek()) while (stack.pop() != null);
            stack.push(arr[i]);
        }

        ArrayList<Integer> output = new ArrayList<>();
        while (stack.peek() != null) {
            output.add(0, stack.pop());
        }

        int[] outputArr = new int[output.size()];
        for (int i = 0; i < outputArr.length; i++){
            outputArr[i] = output.get(i);
        }

        return outputArr;
    }

    public static void printArr(int[] arr){
        StringBuilder str = new StringBuilder("[");
        for (int num: arr) str.append(num + ", ");

        System.out.println(str.substring(0, str.length() - 2) + "]");
    }
}

class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

class Stack{
    public Node head; // unlike Queue, you do not need to track tail node

    public Stack(){}

    // O(1)
    public void push(int data){
        Node temp = head;
        head = new Node(data);
        head.next = temp;
    }

    // O(1)
    // Will return null when head == null, so the returned data type should be Integer, instead of int
    public Integer pop(){
        if (head == null) return null;

        int temp = head.data;
        head = head.next;
        return temp;
    }

    public Integer peek(){
        if (head == null) return null;
        return head.data;
    }
}
