import java.util.*;
import java.io.*;

public class ArrayQueue<E> {

    public static final int CAPACITY = 10;  // default queue capacity
    private E[] Q;                          // E array used to implement the queue  
    private int n;                          // actual capacity of queue
    private int front;                      // index for the top of queue
    private int rear;                       // rear of the queue
    private int size;                       // size of the queue
    
	
    public ArrayQueue(){this(CAPACITY);}

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity){
	n = capacity;
	Q = (E[]) new Object [n]; 
	front = rear = size = 0;
    }
    //
    // NOTE: java does not allow creation of array with parametrised type!
    //
	
    public int size(){return size;}
    
    public boolean isEmpty(){return (size==0);}
    

    public E front() throws ArrayQueueException {

        if (isEmpty()) return null;

        return Q[front];


    }
    
	
    public void enqueue(E element) throws ArrayQueueException {

        if (size >= n)  throw new ArrayQueueException("ArrayQueue is full!");
        Q[rear] = element;

        rear = (rear+1)% n;

        size++;


    }
    

    
    public E dequeue() throws ArrayQueueException {

        if (isEmpty()) throw new ArrayQueueException("Unable to dequeue, queue is Empty");

        E firstElement = Q[front];

        front=(front+1)%n;
        size--;

        return firstElement;}
    

    public String toString(){

        StringBuilder output = new StringBuilder();
        output.append("[");
        
        for(int printIndex = 0 ; printIndex < size; printIndex++){

            output.append(Q[front+printIndex]);
            if(printIndex != size-1)output.append(","); 

            
        }
        return output.append("]").toString();

    }
    
}
	
