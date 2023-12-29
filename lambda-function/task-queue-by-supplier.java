import java.util.function.*;

class MyClass{
    public static void main(String[] args){
        TaskQueue scheduler = new TaskQueue();
        scheduler.push(() -> "Running the first function!!!");
        scheduler.push(() -> "Running the second function~~~");
        scheduler.push(() -> "Running the third function>>>");
        scheduler.push(() -> "Running the fourth function<<<");

        while (scheduler.taskExist()){
            scheduler.run();
        }
    }
}

class Item{
    public Supplier<String> lambda;
    public Item next;

    public Item(Supplier<String> lambda){
        this.lambda = lambda;
    }
}

class Queue{
    public Item head;
    public Item tail;

    public Queue(){}

    public Supplier<String> peekFront(){
        if (head == null) return null;
        return head.lambda;
    }

    public void enqueue(Supplier<String> lambda){
        Item newItem = new Item(lambda);
        if (tail == null){
            head = newItem;
            tail = head;
        } else {
            tail.next = newItem;
            tail = newItem;
        }
    }

    public Supplier<String> dequeue(){
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

    public void push(Supplier<String> lambda){
        queue.enqueue(lambda);
    }

    public boolean taskExist(){
        return queue.peekFront() != null;
    }

    public void run(){
        System.out.println(queue.dequeue().get());
    }
}
