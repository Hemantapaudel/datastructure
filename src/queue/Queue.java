package queue;

public class Queue<T> {
	
	int front,rear,size;
	int capacity;
	Object []array;
	
	 public Queue(int capacity) {
         this.capacity = capacity;
         this.size = 0; 
         rear = capacity - 1;
         front = 0;
         array = new Object[this.capacity];
    }
	
	
	public boolean isFull( ){
		 return (this.size == this.capacity);
	 }
	
	public boolean isEmpty(){
		 return (this.size == 0);
	    }
	
	public void enqueue( T item){
	        if (isFull()){
	        	System.out.println("Queue is already full, Overflow condition");
	        	return;
	        }
	        this.rear = (this.rear + 1)%this.capacity;
	        this.array[this.rear] = item;
	        this.size = this.size + 1;
	       // System.out.println(item+ " enqueued to queue");
	    }

	
	public T dequeue( ){
        if (isEmpty()){
        	System.out.println("Queue is  empty, underflow condition");
        	//return (T)Integer.MIN_VALUE;
        }
        @SuppressWarnings("unchecked")
		T item = (T)array[front];
        this.front =  (this.front +1) % this.capacity;
        this.size =  this.size -1;
        return item;
        
	}
	
	
	public static void main(String[] args) {

		Queue<Integer> queue = new Queue<Integer>(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
		
	}

}
