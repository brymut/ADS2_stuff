
import java.util.*;
import java.io.*;


public class QueueSort<E extends Comparable<E>>  {

    //instance variables
    private ArrayQueue<ArrayQueue<E>> Q;
    public static final int CAPACITY = 10;  // default queue capacity
    private int n;                          // capacity of queue
    private boolean trace;




    // constructors	
    public QueueSort(){this(CAPACITY);}    //constructs queue with default capacity
	
    public QueueSort(int capacity){        // constructs queue with specified capacity
	n = capacity;
	Q = new ArrayQueue<ArrayQueue<E>>(n);
    }


    // methods

    // Take two sorted queues and merge them to produce a third
    // sorted queue
    private ArrayQueue<E> merge(ArrayQueue<E> q1,ArrayQueue<E> q2) throws ArrayQueueException {

        ArrayQueue<E> q3 = new ArrayQueue<E>(q1.size()+q2.size());


        while((!q1.isEmpty()) && (!q2.isEmpty())){

        //If the first element of q1 is smaller than that of q2, it dequeues q1
        //It dequeues element from q1 then enqueues element onto q3.  
            if(q1.front().compareTo(q2.front()) < 0) q3.enqueue(q1.dequeue());

        //If the first element of q1 is smaller than that of q2, it dequeues q1
        //It dequeues element from q1 then enqueues element onto q3.  
            else q3.enqueue(q2.dequeue());


        }
        //if any elements are left over on q1, or q2.. add them on to q3
        if(!q1.isEmpty() ){

            for ( int i = 0; i < q1.size();i++) {
                q3.enqueue(q1.dequeue());

            }

        }

        if (!q2.isEmpty() ){
            
            for ( int i = 0; i < q2.size();i++) {
                q3.enqueue(q2.dequeue());

            }


        }
       

        return q3;
    }
    
    
    // given a queue Q of queues
    //  (1)   <a>if Q is of size 1 deliver the first queue in Q
    //        if Q is of size 2 or more 
    //        <b>  - get the first and second queues off Q
    //        <b>  - merge these two queues to create a third queue
    //        <b>  - add the third queue to the queue
    //        - go back to (1)
    //
    public void sort(){


        while (Q.size() > 1) {  //<a>

           
           Q.enqueue(merge(Q.dequeue(),Q.dequeue())); //<b>
           
         }




    }
    
    
    // <a> - create an ArrayQueue<E> that contains the element 
    // <b> - enqueue it onto Q
    //
    public void add(E element){

        ArrayQueue<E> qNew = new ArrayQueue<E>();   //<a>

        qNew.enqueue(element);   //<a>

        Q.enqueue(qNew);       //<b>

    }
    
   
    // string representation of Queue
    public String toString(){return Q.toString();}

    public void trace(){trace = !trace;}

    public static void main(String[] args) throws IOException {
	Scanner sc = new Scanner(new File(args[0]));
	ArrayList<String> data = new ArrayList<String>();
	while (sc.hasNext()) data.add(sc.next());
	int n = data.size();
	QueueSort<String> QS = new QueueSort<String>(n);
	for (String s : data) QS.add(s);
	if (args.length > 1) QS.trace();
	QS.sort();
	System.out.println(QS);
    }
}
