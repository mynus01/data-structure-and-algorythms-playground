package linkedlist;

public class NewCustomLinkedList {
    private NewCustomNode head;
    private NewCustomNode tail;
    private int length;

    public NewCustomLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public NewCustomLinkedList(int value) {
        NewCustomNode newNode = new NewCustomNode(value, null);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void append(int value) {
        NewCustomNode newNode = new NewCustomNode(value, null);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        length++;
    }
    public void prepend(int value) {
        if (isEmpty()) {
            NewCustomNode newNode = new NewCustomNode(value, null);
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head = new NewCustomNode(value, this.head);
        }
        length++;
    }

    public void insert(int index, int value) {

    }

    public void deleteHead() {}

    public void deleteTail() {}

    public boolean contains(int value) { return false; }

    public int indexOf(int value) { return -1; }

    public boolean isEmpty() {
        return length == 0;
    }

    public NewCustomNode getHead() {
        return head;
    }

    public NewCustomNode getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }
}
