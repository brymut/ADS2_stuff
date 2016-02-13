import java.util.*;
import java.io.*;

public class ArrayQueue<E> {

    //instance variables
    public static final int CAPACITY = 10;  // default queue capacity
    private E[] Q;                          // E array used to implement the queue  
    private int n;                          // actual capacity of queue
    private int front;                      // index for the top of queue
    private int rear;                       // rear of the queue
    private int size;                       // size of the queue
    
	// constructors
    public ArrayQueue(){this(CAPACITY);}   // constructs queue with defualt capacity

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity){     // constructs queue with specified capacity
	n = capacity;
	Q = (E[]) new Object [n];            // safe cast.
	front = rear = size = 0;
    }
    //
    // NOTE: java does not allow creation of array with parametrised type!
    //
	

    //methods
    //returns the size of the queue
    public int size(){return size;}
    //checks if the queue is empty
    public boolean isEmpty(){return (size==0);}
    


    // returns first element of the queue, but doesn't remove.
    // if ArrayQueue is empty returns null
    public E front() throws ArrayQueueException {

        if (isEmpty()) return null;

        return Q[front];


    }
    
	// Inserts element at the rear of the queue
    public void enqueue(E element) throws ArrayQueueException {

        if (size >= n)  throw new ArrayQueueException("ArrayQueue is full!");
        Q[rear] = element;
        

        // use of modulo operator, ideal for treating array circulary.
        // rear will resolve to 0 when the rear index value increments beyond n
        rear = (rear+1)% n;  

        size++;


    }
    

    // Removes and returns the first element of the queue.
    // returns null if the queue is empty
    public E dequeue() throws ArrayQueueException {

        if (isEmpty()) throw new ArrayQueueException("Unable to dequeue, queue is Empty");

        E firstElement = Q[front];

        // use of modulo operator, ideal for treating array circulary.
        // front will resolve to 0 when the front index value increments beyond n

        front=(front+1)%n;
        size--;

        return firstElement;}
    

    // returns the string representation of the Queue, each element separated by a comma
    // using StringBuilder
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
	
