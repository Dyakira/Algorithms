package chapter1;

import java.util.Iterator;

/**
 * Created by Dyakira on 2016/4/7.
 */
public class Bag<Item> implements Iterable<Item>{
    private Node first;//链表的首节点
    private class Node{
        Item item;
        Node next;
    }
    public void add(Item item){
        Node oldFirst = first;
        first.item = item;
        first.next = oldFirst;
    }

    public Iterator<Item> iterator(){ return new ListIterator();}

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
