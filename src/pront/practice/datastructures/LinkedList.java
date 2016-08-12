package pront.practice.datastructures;

/**
 * Created by Pavlos on 15/11/2015.
 */
public class LinkedList<T> {
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
    int size = 0;

    void insert(T data) {
        Node<T> newNode = new Node<T>(data);

        if(head == null) {
            head = newNode;
            tail = head;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    void delete(T data) {
        Node<T> current = head;

        if(head == null) {
            return;
        }
        else if(head.data.equals(data)) {
            head = head.next;
            return;
        }

        while(current.next != null && !current.next.data.equals(data)) {
            current = current.next;

        }

        if(current.next == null) { // node not found
            return;
        }
        else if(current.next == tail && tail.data.equals(data)) {
            tail = current.next;
            tail.next = null;
        }
        else {
            current.next = current.next.next;
        }
    }

    int size() {
        return size;
    }

    void printNodes() {
        Node<T> n = head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(0);
        list.insert(1);
        list.insert(2);
        list.insert(3);

        list.delete(1);
        list.insert(4);
        list.printNodes();
    }
}
