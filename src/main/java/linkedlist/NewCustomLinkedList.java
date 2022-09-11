package linkedlist;

import java.util.NoSuchElementException;

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
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        length++;
    }

    public void prepend(int value) {
        if (isEmpty()) {
            NewCustomNode newNode = new NewCustomNode(value, null);
            head = newNode;
            tail = newNode;
        } else {
            head = new NewCustomNode(value, head);
        }
        length++;
    }

    public void insert(int index, int value) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be less than zero!");
        }
        NewCustomNode node = head;
        for (int i = 0; i < length; i++) {
            if (index == 0) {
                head = new NewCustomNode(value, head.getNext());
            } else if (i == index - 1) {
                node.setNext(new NewCustomNode(value, node.getNext()));
                length++;
                return;
            } else {
                node = node.getNext();
            }
        }
        throw new NoSuchElementException("Index doesn't exist within list!");
    }

    public void deleteHead() {
        if (!isEmpty()) {
            if (length == 1) {
                tail = null;
                head = null;
            } else {
                head = head.getNext();
            }
            length--;
        } else {
            throw new NoSuchElementException("Head cannot be removed if the list is empty!");
        }
    }

    public void deleteTail() {
        if (!isEmpty()) {
            if (length == 1) {
                tail = null;
                head = null;
            } else {
                NewCustomNode newLast = head;

                while (newLast != null) {
                    if (newLast.getNext() == tail) {
                        break;
                    }
                    newLast = newLast.getNext();
                }
                tail.setNext(null);
                tail = newLast;
            }
            length--;
        } else {
            throw new NoSuchElementException("Tail cannot be removed if the list is empty!");
        }
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        NewCustomNode node = head;
        for (int i = 0; i < length; i++) {
            if (node.getValue() == value) {
                return i;
            } else {
                node = node.getNext();
            }
        }
        return -1;
    }

    public NewCustomNode get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be less than zero!");
        }
        NewCustomNode current = head;
        for (int i = 0; i < length; i++) {
            if (i == index) {
                return current;
            } else {
                current = current.getNext();
            }
        }
        throw new NoSuchElementException("Index doesn't exist within list!");
    }

    public void set(int index, int value) {
        NewCustomNode node = get(index);
        node.setValue(value);
    }

    public void remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be less than zero!");
        } else if (index >= length) {
            throw new NoSuchElementException("Index doesn't exist within list!");
        }

        if (index == 0) {
            deleteHead();
        } else if (index == length - 1) {
            deleteTail();
        } else {
            NewCustomNode previousNode = get(index - 1);
            NewCustomNode nodeToBeRemoved = previousNode.getNext();
            previousNode.setNext(nodeToBeRemoved.getNext());
        }
        length--;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    public NewCustomNode getHead() {
        return head;
    }

    public NewCustomNode getTail() {
        return tail;
    }
}
