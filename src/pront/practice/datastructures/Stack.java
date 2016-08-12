package pront.practice.datastructures;

public class Stack<T> {
    private static class Node<T> {
        private T data = null;
        private Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top = null;
    private int size = 0;

    void push(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    T pop() throws Exception {
        if(size == 0) { throw new Exception("Empty stack"); }

        Node<T> tmp = top;
        top = top.next;
        size--;
        return tmp.data;
    }

    int size() {
        return size;
    }

    T peek() throws Exception {
        if(size == 0) { throw new Exception("Empty stack"); }
        return top.data;
    }

    boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

    }
}

