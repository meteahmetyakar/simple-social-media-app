package SocialMedia.LDLinkedList;

import java.util.AbstractList;
import java.util.List;

public class LDLinkedList<E> extends AbstractList<E> implements List<E> {
    private int size;
    private int lazyCounter;
    private Node<E> head;
    private Node<E> tail;

    private static class Node<E> {
        E item;
        Node<E> next;
        boolean deleted;

        Node(E element) {
            this.item = element;
            this.next = null;
            this.deleted = false;
        }
    }

    public LDLinkedList() {
        size = 0;
        head = null;
        tail = null;
        lazyCounter = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> current = head;

        int idx = 0;

        while(idx < index){
            current = current.next;
            if(!current.deleted)
                idx++;
        }
        return current.item;
    }

    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<E>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        Node<E> newNode = new Node<E>(element);
        if (index == size) {
            add(element);
        } else {
            Node<E> current = head;
            int idx = 0;
            while(idx < index)
            {
                current = current.next;
                if(!current.deleted)
                    idx++;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node<E> current = head;
        Node<E> previous = null;

        int idx = 0;

        if(index == 0)
        {
            while(current.deleted)
                current = current.next;
        }
        else
        {
            while(idx < index)
            {
                previous = current;
                current = current.next;
                if(!current.deleted)
                    idx++;
            }
        }

        E item = current.item;
        current.deleted = true;
        size--;

        lazyCounter++;
        if(lazyCounter >= 2)
            removeLazies();

        return item;
    }

    private void removeLazies()
    {
        while(lazyCounter-- > 0)
        {
            Node<E> current = head;
            Node<E> previous = null;

            while(!current.deleted)
            {
                previous = current;
                current = current.next;
            }

            if (current == head) {
                head = current.next;
            } else {
                previous.next = current.next;
            }
        }
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while (current != null) {
            if (!current.deleted) {
                sb.append(current.item.toString());
                if (current.next != null) {
                    sb.append(", ");
                }
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
