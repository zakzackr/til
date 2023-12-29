// Runnableはrunメソッドを一つ持つ関数型インターフェース。
// runメソッドは引数を受け取らず、戻り値もない。

import java.util.Map;
import java.util.HashMap;

class Main{
    public static void main(String[] args){
        EventQueue myEventQueueSystem = new EventQueue();
        myEventQueueSystem.push("Study", () -> System.out.println("You will study math today"));
        myEventQueueSystem.push("Study", () -> System.out.println("You will study music today"));
        myEventQueueSystem.push("WorkOut", () -> System.out.println("You will work out squat 6 times today"));
        myEventQueueSystem.push("WorkOut", () -> System.out.println("You will work out squat 20 Push-up today"));

        myEventQueueSystem.dispatch("Study");
        myEventQueueSystem.dispatch("Study");
        myEventQueueSystem.dispatch("Study");
        myEventQueueSystem.dispatch("WorkOut");
        myEventQueueSystem.dispatch("WorkOut");
        myEventQueueSystem.dispatch("Something");
    }
}

class Item{
    public Runnable data;
    public Item next;

    public Item(Runnable data){
        this.data = data;
    }
}

class Queue{
    public Item head;
    public Item tail;

    public Queue(){}

    public Runnable peekFront(){
        if (head == null) return null;
        return head.data;
    }

    public void enqueue(Runnable data){
        Item newItem = new Item(data);
        if (tail == null){
            tail = newItem;
            head = tail;
        } else {
            tail.next = newItem;
            tail = newItem;
        }
    }

    public Runnable dequeue(){
        if (head == null) return null;
        Item temp = head;
        head = head.next;
        if (head == null) tail = null;
        return temp.data;
    }
}

class EventQueue{
    public Map<String, Queue> eventMap;

    public EventQueue(){
        this.eventMap = new HashMap<>();
    }

    public void push(String event, Runnable data){
        if (eventExists(event)){
            eventMap.get(event).enqueue(data);
        } else {
            Queue q = new Queue();
            q.enqueue(data);
            eventMap.put(event, q);
        }
    }

    public boolean eventExists(String event){
        return eventMap.containsKey(event);
    }

    public void dispatch(String event){
        if (!eventExists(event)) {
            System.out.println("Event is none!");
            return;
        }

        Runnable temp = eventMap.get(event).dequeue();
        if (temp != null) temp.run();
        else System.out.println("Event is none!");
    }
}
