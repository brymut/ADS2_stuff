
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
    // returns the number of elements in the heap
    //
    
    public boolean isEmpty(){return (last==0);}
    //
    // is the heap empty?
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
	
    
    public void insert(E e) throws HeapException {

        if (last == capacity) throw new HeapException("overflow");

        H[last] = e;
        System.out.println((E) H[last]);
        System.out.println((E) H[last/2]);
        System.out.println(((E) H[last]).compareTo((E) H[last/2]) < 0);
        

        //while( ((E) H[last]).compareTo((E) H[last/2]) < 0){
          
        Swap((E) H[last], (E) H[last/2]);
        System.out.println((E) H[last]);
        System.out.println((E) H[last/2]);
           
           //System.out.println("Stuck");
           //System.out.println(((E) H[last]).compareTo((E) H[last/2]) < 0);
           
        //}
        last++;





    }		
    //
    // inserts e into the heap
    // throws exception if heap overflow
    //
    
    @SuppressWarnings("unchecked")
    public E removeMin() throws HeapException {
	return null;
    }
    //
    // removes and returns smallest element of the heap
    // throws exception if heap is empty
    // NOTE: must cast result to class (E)
    //       see min() above
    //

    public void Swap(E e1, E e2){
        E temp = e1;
        e1 = e2;
        e2 = temp;



    }
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

