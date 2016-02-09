
import java.util.*;
import java.io.*;


public class QueueSort<E extends Comparable<E>>  {

    private ArrayQueue<ArrayQueue<E>> Q;
    public static final int CAPACITY = 10;  // default queue capacity
    private int n;    
    private boolean trace;
	
    public QueueSort(){this(CAPACITY);}
	
    public QueueSort(int capacity){
	n = capacity;
	Q = new ArrayQueue<ArrayQueue<E>>(n);
    }





    private ArrayQueue<E> merge(ArrayQueue<E> q1,ArrayQueue<E> q2) throws ArrayQueueException {

        ArrayQueue<E> qNew = new ArrayQueue<E>();
        int sizeDiff = q1.size() - q2.size();

        if (sizeDiff == 0) {

            for(int currentCompareIndex = 0 ; currentCompareIndex < q1.size(); currentCompareIndex++){

                if(q1.front().compareTo(q2.front()) >= 0){

                    qNew.enqueue(q1.dequeue());
                    qNew.enqueue(q2.dequeue());
                } 
               // if(q2.front().compareTo(q1.front()) >= 0)//
               else {
                    qNew.enqueue(q2.dequeue()); 
                    qNew.enqueue(q1.dequeue());
                    }       
            
            }

        if (sizeDiff < 0) {

            for(int currentCompareIndex = 0 ; currentCompareIndex < q1.size(); currentCompareIndex++){

                if(q1.front().compareTo(q2.front()) >= 0){

                    qNew.enqueue(q1.dequeue());
                    qNew.enqueue(q2.dequeue());
                } 
                if(q2.front().compareTo(q1.front()) >= 0) {
                    qNew.enqueue(q2.dequeue()); 
                    qNew.enqueue(q1.dequeue());
                    }       
            
            }

            while(q2.size() > 0){
                qNew.enqueue(q2.dequeue());
            }


            
        }

        if (sizeDiff > 0) {

            for(int currentCompareIndex = 0 ; currentCompareIndex < q2.size(); currentCompareIndex++){

                if(q1.front().compareTo(q2.front()) >= 0){

                    qNew.enqueue(q1.dequeue());
                    qNew.enqueue(q2.dequeue());
                } 
                if(q2.front().compareTo(q1.front()) >= 0) {
                    qNew.enqueue(q2.dequeue()); 
                    qNew.enqueue(q1.dequeue());
                    }       
            
            }

            while(q1.size() > 0){
                qNew.enqueue(q1.dequeue());
            }


            
        }



        }

        return qNew;
    }
    //
    // IMPLEMENT ME
    // Take two sorted queues and merge them to produce a third
    // sorted queue
    //

    public void sort(){
        int counter = 0;
        while (Q.size() > 1) {
            
            counter++;

            ArrayQueue<E> QNew = new ArrayQueue<E>();

            QNew = merge(Q.dequeue(),Q.dequeue());

            Q.enqueue(QNew);
            System.out.println(Q.toString());

        }




    }
    //
    // IMPLEMENT ME
    // given a queue Q of queues
    // (1) if Q is of size 1 deliver the first queue in Q
    // (2) if Q is of size 2 or more 
    //     - get the first and second queues off Q
    //     - merge these two queues to create a third queue
    //     - add the third queue to the queue
    //     - go back to (1)
    //

    public void add(E element){

        ArrayQueue<E> qNew = new ArrayQueue<E>();

        qNew.enqueue(element);

        Q.enqueue(qNew);

    }
    //
    // IMPLEMENT ME
    // create an ArrayQueue<E> that contains the element
    // enqueue it onto Q
    //
    
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
