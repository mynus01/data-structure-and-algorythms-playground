package linkedlist.java;

public class CustomNode {
    private int value;
    private CustomNode next;

    public CustomNode(int value, CustomNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public CustomNode getNext() {
        return next;
    }

    public void setNext(CustomNode next) {
        this.next = next;
    }
}