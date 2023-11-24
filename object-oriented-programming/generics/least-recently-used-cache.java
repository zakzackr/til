import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LRUCache<String> c = new LRUCache<String>(10);
        c.put(0, "Hello");
        c.put(4, "Good Morning");
        c.put(1, "Good Afternoon");
        c.put(7, "Good Evening");
        c.put(4, "GoodBye");
        System.out.println(c.get(0));
        System.out.println(c.cacheList);
    }
}

interface Stack<E>{
    public abstract E peekBack();
    public abstract E popBack();
    public abstract void pushBack(Node<E> node);
}

interface Queue<E>{
    public abstract E peekFront();
    public abstract E popFront();
    public abstract void pushBack(Node<E> node);
}

class Node<E>{
    public int key;
    public E data;
    public Node<E> prev;
    public Node<E> next;

    public Node(int key, E data){
        this.key = key;
        this.data = data;
    }
}

abstract class AbstractDoublyLinkedList<E> implements Stack<E>, Queue<E>{
    protected Node<E> head;
    protected Node<E> tail;

    public AbstractDoublyLinkedList(){}

    public abstract void deleteNode(Node<E> node);
}

// 両方向リスト
class CacheList<E> extends AbstractDoublyLinkedList<E>{
    public CacheList(){
        super();
    }

    public E peekBack(){
        if (tail == null) return null;
        return tail.data;
    }

    public E popBack(){
        if (tail == null) return null;

        Node<E> temp = tail;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;

        return temp.data;
    }

    public void pushBack(Node<E> node){
        if (head == null){
            head = node;
            tail = head;
        } else{
            node.prev = tail;
            tail.next = node;
            tail = tail.next;
        }
    }

    public E peekFront(){
        if (head == null) return null;
        return head.data;
    }

    public E popFront(){
        if (head == null) return null;

        Node<E> temp = head;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;

        return temp.data;
    }

    public void deleteNode(Node<E> node){
        if (node == null) return;

        if (node == head) popFront();
        else if (node == tail) popBack();
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public String toString(){
        StringBuilder str = new StringBuilder("[");
        Node<E> iterator = head;
        while(iterator != null){
            str.append("< " + iterator.key + ", " + iterator.data + " >, ");
            iterator = iterator.next;
        }
        str.append("]");
        return str.toString();
    }
}

// キャッシュを実装するためのコンテナ
class LRUCache<E>{
    protected int capacity;
    protected Map<Integer, Node<E>> cacheMap;
    protected CacheList<E> cacheList;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.cacheMap = new HashMap<Integer, Node<E>>();  // キーとノードをハッシュマップに格納
        this.cacheList = new CacheList<E>();  // 両方向リスト（先頭: 古い要素, 末尾: 新しい要素）
    }

    public E get(int key){
        if (!cacheMap.containsKey(key)) return null;

        Node<E> temp = cacheMap.get(key);
        cacheList.deleteNode(temp);
        temp.prev = null;
        temp.next = null;
        cacheList.pushBack(temp);

        return temp.data;
    }

    public void put(int key, E data){
        Node<E> temp;
        if (cacheMap.containsKey(key)){
            temp = cacheMap.get(key);
            cacheList.deleteNode(temp);
            temp.data = data;
            temp.prev = null;
            temp.next = null;
        } else if (cacheMap.size() == capacity){
            temp = cacheList.head;
            cacheList.deleteNode(temp);
            cacheMap.remove(temp.key);
            temp = new Node<E>(key, data);
        } else {
            temp = new Node<E>(key, data);
            cacheMap.put(key, temp);
        }

        cacheList.pushBack(temp);
    }
}
