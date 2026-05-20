package DataStruct;

class Node<T>{
    T data;
    Node<T> prev;
    Node<T> next;

    public void Node(T data){
        this.data = data;
    }
}


class DoublyLinkedList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insert(int idx, T data){
        if(idx < 0 || idx > size) throw new IndexOutOfBoundsException("잘못된 접근입니다.");

        Node<T> newNode = new Node<>(data);
    }

    public void append(T data){
        insert(size, data);
    }

    public T deleteAtIdx(int idx){
        if(idx < 0 || idx >= size) throw new IndexOutOfBoundsException("잘못된 접근입니다.");
        
        Node<T> now = head;
        for(int i=0; i<idx; i++){
            now = now.next;
        }
        return a;
    }

    private void unlink(Node<T> targetNode){

    }

    public void display(){

    }
}

public class DoublyLinkedListImpl {
    public static void main(String[] args) {
        
    }
}
