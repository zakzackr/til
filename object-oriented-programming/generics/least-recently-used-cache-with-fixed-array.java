public class Main {
    public static void main(String[] args) {
        LRUCache<String> cache = new LRUCache<>(5);
        cache.put(0, "apple");
        cache.put(1, "berry");
        cache.put(2, "cherry");
        cache.put(3, "dragon fruit");
        cache.put(4, "egg fruit");

        System.out.println(cache);  // [<0, apple><1, berry><2, cherry><3, dragon fruit><4, egg fruit>]

        System.out.println(cache.get(1));  // berry

        System.out.println(cache);  // [<0, apple><2, cherry><3, dragon fruit><4, egg fruit><1, berry>]
    }
}

interface Stack<E>{
    public abstract E peekBack();
    public abstract void pushBack(Node<E> node);
    public abstract E popBack();
}

interface Queue<E>{
    public abstract E peekFirst();
    public abstract void pushBack(Node<E> node);
    public abstract E popFirst();
}

class Node<E>{
    public int key;
    public E data;
    public Node<E> next;
    public Node<E> prev;

    public Node(int key, E data){
        this.key = key;
        this.data = data;
    }
}

abstract class AbstractDoublyLinkedList<E> implements Stack<E>, Queue<E>{
    protected Node<E> head;
    protected Node<E> tail;
    public AbstractDoublyLinkedList(){};

    public abstract void deleteNode(Node<E> node);
}

// 先頭から末尾に向かって、徐々に新しいデータになる
class CacheList<E> extends AbstractDoublyLinkedList<E>{
    public CacheList(){
        super();
    }


    public E peekBack(){
        if (tail == null) return null;
        return tail.data;
    }

    // 一番新しいデータをキャッシュに追加
    public void pushBack(Node<E> node){
        if (tail == null){
            tail = node;
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }

    }

    public E popBack(){
        if (tail == null) return null;

        Node<E> deleted = tail;
        tail = tail.prev;
        if (tail == null) head = null;
        else tail.next = null;

        return deleted.data;
    }

    public E peekFirst(){
        if (head == null) return null;
        return head.data;
    }

    // 一番古いデータをキャッシュから削除
    public E popFirst(){
        if (head == null) return null;

        Node<E> deleted = head;
        head = head.next;
        if (head == null) tail = null;
        else head.prev = null;

        return deleted.data;
    }

    public void deleteNode(Node<E> node){
        if (node == null) return;

        if (node == head) popFirst();
        else if (node == tail) popBack();
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;

        while (current != null){
            sb.append("<" + current.key + ", " + current.data + ">");
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }
}

// deleteNodeでリストの真ん中のデータを削除する際、O(n)になる。
// 任意のノードにO(1)でアクセスするために固定配列を使用。（空間計算量とのトレードオフ）
class LRUCache<E>{
    private int capacity;
    public Node[] arr;  // index: key, element: node
    private CacheList<E> cacheList = new CacheList<>();

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.arr = new Node[capacity];
    }

    // Logical Error!!
    // initializing the arr with the default value of capacity which is 0
//    private int capacity;
//    public Node[] arr = new Node[capacity];
//    private CacheList<E> cacheList = new CacheList<>();
//
//    public LRUCache(int capacity){
//        this.capacity = capacity;
//    }

    public E get(int key){
        if (arr[key] == null) return null;

        Node<E> temp = arr[key];
        cacheList.deleteNode(temp);
        temp.prev = null;
        temp.next = null;
        cacheList.pushBack(temp);

        return temp.data;
    }

    public void put(int key, E data){
        Node<E> temp;

        // key should be between 0 and (capacity - 1)
        if (key > capacity - 1) {
            System.out.println("cannot save the data on cache as the key is too large");
            return;
        }

        if (arr[key] != null){
            temp = arr[key];
            cacheList.deleteNode(temp);
            temp.prev = null;
            temp.next = null;
            temp.data = data;
        } else {
            temp = new Node<>(key, data);
            arr[key] = temp;
        }

        cacheList.pushBack(temp);
    }

    public String toString(){
        return cacheList.toString();
    }
}





