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

        if (size == Q.length)  throw new ArrayQueueException("ArrayQueue is full!");

        n = (front+size)% Q.length;

        Q[n] = element;
        size++;


    }
    

    
    public E dequeue() throws ArrayQueueException {

        if (isEmpty()) return null;

        E firstElement = Q[front];

        Q[front] = null;

        front = (front+1) % Q.length;
        size--;

        return firstElement;}
    

    public String toString(){


/*

 if(isEmpty())return "the ArrayQueue is empty \n";

        String output = "[";

        while(front()!= null){

            output = output + dequeue().toString();
            output = output + ",";

        }

        output = output + "]";




*/






        return "";




    }
    //
    // IMPLEMENT ME
    //
    //
    // NOTE: if the queue contains 1,2,3 then return "[1,2,3]"
    //       if the queue contains 1 then return "[1]"
    //       if the queue is empty return "[]"
    //
}
	
