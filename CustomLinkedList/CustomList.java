package CustomLinkedList;

public class CustomList {
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

    private class Node {
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

}


