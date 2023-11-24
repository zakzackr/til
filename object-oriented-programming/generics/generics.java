public class Main {
    public static void main(String[] args) {
        StackGenerics<Integer> stackInt = new StackGenerics(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(stackInt);  // [1 2 3 4 5]

        System.out.println(stackInt.pop());  // 1
        System.out.println(stackInt.pop());  // 2
        System.out.println(stackInt.pop());  // 3
        System.out.println(stackInt);  // [4 5]

        stackInt.push(3);
        stackInt.push(2);
        stackInt.push(1);
        System.out.println(stackInt);  // [1 2 3 4 5]
        System.out.println(stackInt.pop() * stackInt.pop());  // 2

        
        StackGenerics<String> stackStr = new StackGenerics(new String[]{"apple", "banana", "cherry"});
        System.out.println(stackStr);  // [apple banana cherry]
        System.out.println(stackStr.pop());  // apple
        System.out.println(stackStr.pop());  // banana
        System.out.println(stackStr);  // [cherry]
        stackStr.push("water melon");
        System.out.println(stackStr);  // [water melon cherry]

        // ERROR!!
//        StackGenerics<String> stackMixedTypes = new StackGenerics();
//        stackMixedTypes.push("apple");
//        stackMixedTypes.push(1);
    }
}

class Node<E>{
    public E data;
    public Node<E> next;

    public Node(E data){
        this.data = data;
    }
}

class StackGenerics<E>{
    public Node<E> head;

    public StackGenerics(){};

    public StackGenerics(E[] arr){
        if (arr.length == 0){
            head = null;
            return;
        }

        this.head = new Node(arr[0]);
        Node<E> current = this.head;
        for (int i = 1; i < arr.length; i++){
            current.next = new Node(arr[i]);
            current = current.next;
        }
    }

    public E pop(){
        if (head == null) return null;

        Node<E> deleted = head;
        head = head.next;
        return deleted.data;
    }

    public void push(E element) {
        Node<E> temp = head;
        head = new Node(element);
        head.next = temp;
    }

    public E peek(){
        if (head == null) return null;
        return head.data;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null){
            if (current.next != null) sb.append(current.data + " ");
            else sb.append(current.data);

            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }
}
