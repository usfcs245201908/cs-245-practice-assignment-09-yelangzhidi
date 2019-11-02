import java.util.Arrays;

public class BinaryHeap {
    private final int DEFAULTSIZE = 10;
    private int size;
    private int[] heap;

    /**
     * Constructor
     */
    public BinaryHeap(){
        size = 0;
        heap = new int[DEFAULTSIZE];
    }

    /**
     * add: insert an Integer into heap and modify the order.
     * @param priority the Integer
     */
    public void add(int priority){
        if (size == heap.length)
            growArray();
        heap[size++] = priority;
        int child = size-1;
        int parent = (child-1)/2;
        while (parent >= 0 && heap[child] < heap[parent]) {
            swap(child, parent);
            child = parent;
            parent = (child-1)/2;
        }
    }

    /**
     * remove: remove the minimum number in heap and modify the order.
     * @return heap[0]
     */
    public int remove(){
        if (size == 0)
            throw new IndexOutOfBoundsException();
        int temp = heap[0];
        heap[0] = heap[--size];
        siftdown(0);
        return temp;
    }

    /**
     * siftdown: put the argument to the position it should be.
     * @param parent the index in heap.
     */
    private void siftdown(int parent){
        int child = parent*2+1;
        if(child < size){
            if (child + 1 < size)
                if (heap[child] > heap[child + 1])
                    child = child + 1; // right child
            if (heap[child] < heap[parent]) {
                swap(child, parent);
                siftdown(child);
            }
        }
    }

    /**
     * swap: swap two arguments in heap.
     * @param a the first index
     * @param b the second index
     */
    private void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    /**
     * growArray: increase the heap size.
     */
    private void growArray(){
        heap = Arrays.copyOfRange(heap,0,size*2);
    }
}
