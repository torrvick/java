package CustomLinkedList;

import java.util.Iterator;

public class CustomList<T> implements Iterable<T>{
    private Node<T> last = null;
    private Node<T> first = null;
    private int size = 0;

    public void add(T data) {
        Node<T> elem = new Node<>(data);
        if (size == 0) {
            first = elem;
        } else {
            last.setNext(elem);
        }
        last = elem;
        size++;
    }
    
    public void print() {
        Node<T> currNode = first; 
        System.out.print("CustomList: "); 
        while (currNode != null) { 
            System.out.print(currNode.getData() + " "); 
            currNode = currNode.getNext(); 
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> currNode = first;

        @Override
        public boolean hasNext() {
            return currNode != null;
        }

        @Override
        public T next() {
            T data = currNode.getData();
            currNode = currNode.getNext();
            return data;
        }
    }

    private static class Node<T> {
        T data;
        Node<T> next;
    
        Node(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
        
        @Override
        public String toString() {
            return "{" +
                " data='" + getData() + "'" +
                ", next='" + getNext() + "'" +
                "}";
    }

    }

}


