package chapter1;

import java.util.Iterator;

/**
 * Created by Dyakira on 2016/4/7.
 */
public class Queue<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){ return first == null; }  //或N==0
    public int size(){ return N; }
    //向表尾添加元素
    public void enqueue(Item item){
        Node oldLast = last;
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }else{
            oldLast.next = last;
        }
        N++;
    }
    //从表头删除元素
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return item;
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
