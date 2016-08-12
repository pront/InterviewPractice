package pront.practice.datastructures;

/**
 * Created by Pavlos on 11/15/2015.
 */
/**
 * CSE 373, Winter 2011, Jessica Miller
 * The BinaryHeap is an -generic- implementation of the PriorityQueue interface.
 * This is a binary min-heap implementation of the priority queue ADT.
 */
import java.util.Arrays;
import java.util.PriorityQueue;

public class BinaryHeap<T extends Comparable<T>> extends PriorityQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    protected T[] array;
    protected int size;

    /**
     * Constructs a new BinaryHeap.
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap () {
        // Java doesn't allow construction of arrays of placeholder data types
        array = (T[])new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }


    /**
     * Adds a value to the min-heap.
     */
    public boolean add(T value) {
        // grow array if needed
        if (size >= array.length - 1) {
            array = this.resize();
        }

        // place element into heap at bottom and then ensure that the heap properties still hold
        size++;
        array[size] = value;

        bubbleUp();
        return true;
    }


    /**
     * Returns true if the heap has no elements; false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns (but does not remove) the minimum element in the heap.
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        return array[1];
    }


    /**
     * Removes and returns the minimum element in the heap.
     */
    public T remove() {
        T result = peek();

        array[1] = array[size];
        array[size] = null;
        size--;

        bubbleDown();
        return result;
    }


    /**
     * Returns a String representation of BinaryHeap with values stored with
     * heap structure and order properties.
     */
    public String toString() {
        return Arrays.toString(array);
    }


    /**
     * Performs the "bubble down" operation to place the element that is at the
     * root of the heap in its correct place so that the heap maintains the
     * min-heap order property.
     */
    protected void bubbleDown() {
        int index = 1;

        // bubble down
        while (hasLeftChild(index)) {
            // which of my children is smaller?
            int smallerChild = leftIndex(index);

            // bubble with the smaller child, if I have a smaller child
            if (hasRightChild(index)
                    && array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) {
                smallerChild = rightIndex(index);
            }

            if (array[index].compareTo(array[smallerChild]) > 0) {
                swap(index, smallerChild);
            } else {
                // otherwise, get outta here!
                break;
            }

            // make sure to update loop counter/index of where last el is put
            index = smallerChild;
        }
    }


    /**
     * Performs the "bubble up" operation to place a newly inserted element
     * (i.e. the element that is at the size index) in its correct place so
     * that the heap maintains the min-heap order property.
     */
    protected void bubbleUp() {
        int index = this.size;

        // starting from the last element, swap elements until the parent is less or equal to current element
        while (hasParent(index)
                && (parent(index).compareTo(array[index]) > 0)) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    protected boolean hasParent(int i) {
        return i > 1;
    }

    protected int leftIndex(int i) {
        return i * 2;
    }

    protected int rightIndex(int i) {
        return i * 2 + 1;
    }

    protected boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }

    protected boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }

    protected boolean isLeaf(int i) {
        return !hasLeftChild(i) && !hasRightChild(i) && i <= this.size;
    }

    protected T parent(int i) {
        return array[parentIndex(i)];
    }

    protected int parentIndex(int i) {
        return i / 2;
    }

    protected T[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }

    protected void swap(int index1, int index2) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public void traversal() {
        traversal(1);
    }

    public void traversal(int i) {
        if( i > this.size) {
            return;
        }

        System.out.println(array[i]);

        if(hasLeftChild(i)) {
            traversal(leftIndex(i));
        }
        if(hasRightChild(i)) {
            traversal(rightIndex(i));
        }
    }

    public static void main(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(10); heap.add(11); heap.add(4); heap.add(2); heap.add(3);  heap.add(12);
        heap.traversal();
    }
}