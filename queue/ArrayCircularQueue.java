import java.util.NoSuchElementException;

class ArrayCircularQueue<T> implements Queue<T>{

    private T[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity; 

    @SuppressWarnings("unchecked")
    public ArrayCircularQueue(int capacity){
        this.queue = (T[])new Object[capacity];
        this.front=-1;
        this.rear=-1;
        this.size=0;
        this.capacity=capacity;

    }

    @Override
    public void enqueue(T item) {
        if(size == capacity){
            throw new IllegalStateException("Queue is full");
        }

        if(rear == -1 && front == -1){
            queue[++rear] = item;
            ++front;
        }else {
    
                rear = (rear+1)%capacity;
                queue[rear] = item;
            }
        size++;
        System.out.println("front : " + front + " , rear : " + rear + " , size : " + size);
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }

        T item = queue[front];
        if(front == rear){//   when queue is empty or  if there is only one element in the queue then reset the front and rear to -1
            front = -1;
            rear = -1;

        }else{
            front = (front+1)%capacity;
        }
        size--;
        return item; 
    }

    @Override
    public T peek() {
        if(size == 0){
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front]; 
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
}