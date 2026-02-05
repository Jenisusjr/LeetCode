class MyCircularQueue {

    int data[];
    int size ;
    int front ;
    int rear;

    public MyCircularQueue(int k) {
        data = new int[k];
        size = k;
        front = rear = -1;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        
        if(rear == -1) front = rear = 0;
        else rear = ((rear + 1) % size);
        data[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

        if(rear == front) front = rear = -1;
        else front = (front + 1 ) % size;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;

        int val = data[front];
        return val;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;

        int val = data[rear];
        return val;
    }
    
    public boolean isEmpty() {
        return (front == -1);
    }
    
    public boolean isFull() {
        return ((rear + 1) % size == front);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */