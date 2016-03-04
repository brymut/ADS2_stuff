
public class Heap <E extends Comparable<E>> {
 
    private Object H[];   // contains the objects in the heap
    private int last;     // index of last element in heap
    private int capacity; // max number of elements in heap  

    public Heap(int n){
	capacity = n;
	H        = new Object[capacity+1];
	last     = 0;
    }
    //
    // create a heap with capacity n
    // NOTE: H is an array of objects
    //       must use casting when delivering the minimum
    //       See min() below.
    //       This must also be done in removeMin()
    //

    public Heap(){this(7);}
    //
    // by default, create a new heap with capacity 7
    //

    @SuppressWarnings("unchecked")
    private int compare(Object x,Object y){return ((E)x).compareTo((E)y);}
    
    public int size(){return last;}
    //
    // returns the number of elements in the heap using the value of last
    //
    
    public boolean isEmpty(){return (last==0);}
    //
    // is the heap empty? using the value of Last
    //
    
    @SuppressWarnings("unchecked")
    public E min() throws HeapException {

	if (isEmpty()) throw new HeapException("underflow");

	return (E) H[1];
    }
    //
    // returns element with smallest key, without removal
    // NOTE: must use casting to class (E)
    //
	
    public void swap(int e1, int e2, Object H[]){

        E temp = (E) H[e1];
        H[e1] = (E) H[e2];
        H[e2] = (E) temp;
        
    }

    private boolean hasLeft(int e, Object H[]){ return (2*e ) <= last;


       
    }
    private boolean hasRight(int e, Object H[]){ return (2*e +1) <= last;

        
    }
    private void upHeap(int j){

    if (j/2 == 0 ) return;

            
    if ( compare( H[j], H[(j/2)] ) < 0){
        swap(j, j/2, H);
        upHeap(j/2);
    }
    }
    
    
    public void insert(E e) throws HeapException {

        if (last == capacity) throw new HeapException("overflow");

        last++;
        H[last] = e;

        upHeap(last);
        



    }

    //
    // inserts e into the heap
    // throws exception if heap overflow
    //
    private void bubbleDown (int j) throws ArrayIndexOutOfBoundsException{
        
        
        int min = 2*j;

        if ( hasRight(j,H)){
            if(compare ( H[2*j],  H[(2*j)+1] ) > 0) min = (2*j)+1;

       }
       
       if (hasLeft(j,H)) {
        
        if ( compare( H[j], H[min]) > 0 ){
            swap( j, min,H);
            bubbleDown(min);
        }


       }

        




    }
    


    @SuppressWarnings("unchecked")
    public E removeMin() throws HeapException, ArrayIndexOutOfBoundsException {

        if (isEmpty()) throw new HeapException("underflow");


        E save = (E) H[1];

        H[1] = H[last];

        H[last] = null;

        last --;



        bubbleDown(1);

        return save;



    }
    //
    // removes and returns smallest element of the heap
    // throws exception if heap is empty
    // NOTE: must cast result to class (E)
    //       see min() above
    //

    

     


    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 1; i <= last ; i++) {

            if (i > 1) output.append(",");
            E item = (E) H[i];
            output.append(item);            
            
        }

        return output.append("]").toString();        
    }
    //
    // outputs the entries in H in the order H[1] to H[last]
    // in same style as used in ArrayQueue
    // 
    // 
    
}

