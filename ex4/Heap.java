
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
	
    public void Swap(int e1, int e2, Object H[]){

        E temp = (E) H[e1];
        H[e1] = (E) H[e2];
        H[e2] = (E) temp;
        
    }

    private boolean hasLeft(int e, Object H[]){

        if ( ((E) H[2*e]) == null) return false;
        else return true;
    }
    private boolean hasRight(int e, Object H[]){

        if ( ((E) H[(2*e) + 1]) == null) return false;
        else return true;
    }
    
    public void insert(E e) throws HeapException {

        if (last == capacity) throw new HeapException("overflow");

        H[last] = e;
        

        int j = last;

        while (j > 0){
            if( compare( H[j], H[(j-1)/2]) < 0){
                Swap(j,(j-1)/2, H);
            }
            j--;
        }

        last++;

    }

    //
    // inserts e into the heap
    // throws exception if heap overflow
    //
    
    @SuppressWarnings("unchecked")
    public E removeMin() throws HeapException {


        if (isEmpty()) throw new HeapException("underflow");

	    E min =  (E) H[0];

        H[0] = (E) H[last-1];

        System.out.println(toString());
        int j = 0;

        while (hasLeft(j,H) ){

            int min_val_of_branch= 2*j;
            
            if( hasRight(j,H)){
                if ( compare( ((E)H[2*j]) , ((E) H[(2*j)+1]) ) > 0 ) min_val_of_branch = (2*j)+1;
            }

            if( compare( H[min_val_of_branch], H[j]) >= 0){
               break;
            }

            Swap(j,min_val_of_branch,H);
            j  = min_val_of_branch;
           
        }
        
        last--;
        return min;


    }
    //
    // removes and returns smallest element of the heap
    // throws exception if heap is empty
    // NOTE: must cast result to class (E)
    //       see min() above
    //

    

     


    public String toString(){
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < last; i++ ) {
            if (i != 0 ) output.append(","); 
            E e = (E) H[i];
            output.append(e);
            
        }

	return output.toString();
    }
    //
    // outputs the entries in H in the order H[1] to H[last]
    // in same style as used in ArrayQueue
    // 
    // 
    
}

