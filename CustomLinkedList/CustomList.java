package CustomLinkedList;

import java.util.Iterator;

public class CustomList implements Iterable<Node>{
    private Node last = null;
    private Node first = null;
    private int size = 0;


    public void add(int data) {
        Node elem = new Node(data);
        if (size == 0) {
            first = elem;
        } else {
            last.setNext(elem);
        }
        last = elem;
        size++;
    }
    
    public void print() {
        Node currNode = first; 
        System.out.print("CustomList: "); 
        while (currNode != null) { 
            System.out.print(currNode.getData() + " "); 
            currNode = currNode.getNext(); 
        }
    }

    public class Node {
        private int data;
        private Node next;
    
        Node(int data) {
            this.data = data;
        }

        public int getData() {
            return this.data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
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

    @Override
        public Iterator<Node> iterator() {
            return new Iterator<Node>() {
                int counter = 0;
                Node currNode = first;
                @Override
                public boolean hasNext() {
                    if (currNode != null) return true;
                    return false;
                }

                @Override
                public Node next() {
                    return currNode.getNext();

                }
            };
        }


    
}


