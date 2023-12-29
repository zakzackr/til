import java.util.function.*;

// Runnableはrunメソッドを一つ持つ関数型インターフェース。
// runメソッドは引数を受け取らず、戻り値もない。

class MyClass{
    public static void main(String[] args){
        TaskQueue scheduler = new TaskQueue();
        scheduler.push(() -> System.out.println("Running the first function!!!"));
        scheduler.push(() -> System.out.println("Running the second function~~~"));
        scheduler.push(() -> System.out.println("Running the third function>>>"));
        scheduler.push(() -> System.out.println("Running the fourth function<<<"));

        while (scheduler.taskExist()){
            scheduler.run();
        }
    }
}

class Item{
    public Runnable lambda;
    public Item next;

    public Item(Runnable lambda){
        this.lambda = lambda;
    }
}

class Queue{
    public Item head;
    public Item tail;

    public Queue(){}

    public Runnable peekFront(){
        if (head == null) return null;
        return head.lambda;
    }

    public void enqueue(Runnable lambda){
        Item newItem = new Item(lambda);
        if (tail == null){
            head = newItem;
            tail = head;
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
        return temp.lambda;
    }
}

class TaskQueue{
    public Queue queue;

    public TaskQueue(){
        this.queue = new Queue();
    }

    public void push(Runnable lambda){
        queue.enqueue(lambda);
    }

    public boolean taskExist(){
        return queue.peekFront() != null;
    }

    public void run(){
        queue.dequeue().run();
    }
}
