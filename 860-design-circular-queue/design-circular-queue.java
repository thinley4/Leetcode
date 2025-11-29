class MyCircularQueue {
    // fix size array
    int[] data;
    int front = 0;
    int rear = -1;
    int size = 0; // track of size
    
    public MyCircularQueue(int k) {
        data = new int[k];
    }
    
    public boolean enQueue(int value) {
        //check full
        if(size == data.length)
            return false;
        
        rear = (rear+1) % data.length;
        data[rear] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        //check empty
        if(size == 0)
            return false;
        
        front = (front+1) % data.length;
        size--;
        return true;
    }
    
    public int Front() {
        return size == 0 ? -1 : data[front];
    }
    
    public int Rear() {
        return size == 0 ? -1 : data[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == data.length;
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