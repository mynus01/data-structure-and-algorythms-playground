package linkedlist.java;

public class NewCustomNode {
    private int value;
    private NewCustomNode next;

    public NewCustomNode(int value, NewCustomNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NewCustomNode getNext() {
        return next;
    }

    public void setNext(NewCustomNode next) {
        this.next = next;
    }
}