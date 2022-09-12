package linkedlist.java;

import java.util.NoSuchElementException;

public class CustomLinkedList {
    private CustomNode head;
    private CustomNode tail;
    private int length;

    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public CustomLinkedList(int value) {
        CustomNode newNode = new CustomNode(value, null);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void append(int value) {
        CustomNode newNode = new CustomNode(value, null);
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
            CustomNode newNode = new CustomNode(value, null);
            head = newNode;
            tail = newNode;
        } else {
            head = new CustomNode(value, head);
        }
        length++;
    }

    public void insert(int index, int value) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be less than zero!");
        }
        CustomNode node = head;
        for (int i = 0; i < length; i++) {
            if (index == 0) {
                head = new CustomNode(value, head.getNext());
            } else if (i == index - 1) {
                node.setNext(new CustomNode(value, node.getNext()));
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
                CustomNode newLast = head;

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
        CustomNode node = head;
        for (int i = 0; i < length; i++) {
            if (node.getValue() == value) {
                return i;
            } else {
                node = node.getNext();
            }
        }
        return -1;
    }

    public CustomNode get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be less than zero!");
        }
        CustomNode current = head;
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
        CustomNode node = get(index);
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
            CustomNode previousNode = get(index - 1);
            CustomNode nodeToBeRemoved = previousNode.getNext();
            previousNode.setNext(nodeToBeRemoved.getNext());
            nodeToBeRemoved.setNext(null);
        }
        length--;
    }


    public void reverse() {
        CustomNode node = head;
        head = tail;
        tail = node;

        CustomNode nextNode;
        CustomNode previousNode = null;
        for (int i = 0; i < length; i++) {
            nextNode = node.getNext();
            node.setNext(previousNode);
            previousNode = node;
            node = nextNode;
        }
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    public CustomNode getHead() {
        return head;
    }

    public CustomNode getTail() {
        return tail;
    }
}
