package pront.practice.datastructures;


import java.util.PriorityQueue;

public class Queue<T> {
    private static class Node<T> {
        private T data = null;
        private Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object obj) {
            return data.equals(obj);
        }

        @Override
        public int hashCode() {
            return data.hashCode();
        }
    }

    Node<T> head = null;
    Node<T> tail = null;

    void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if(tail != null) {
            tail.next = newNode;
        }
        tail = newNode;

        if(head == null) {
            head = tail;
        }
    }

    T dequeue() {
        if(head == null) {
            return null;
        }

        T headData = head.data;
        head = head.next;

        if(head == null) {
            tail = null;
        }
        return headData;
    }

    T peek() {
        return head == null ? null : head.data;
    }

    boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(0); q.enqueue(1); q.enqueue(2);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        q.enqueue(3);

        System.out.println(q.dequeue());

        q.enqueue(4);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        System.out.println("Empty: " + q.isEmpty());
    }
}
