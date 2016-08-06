package chapter1;

import java.util.Iterator;

/**
 * Created by Dyakira on 2016/4/7.
 */
public class Stack<Item> implements Iterable<Item>{
    private Node first; //栈顶
    private int N; //元素数量
    private class Node{
        //定义了节点的嵌套类
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null; //或N == 0
    }
    public int size(){ return N; }
    //向栈顶添加元素
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    //从栈顶删除元素
    //错误做法：找不到first之后的节点 (first.next = null; return first.item;)
    public Item pop(){
        Item item = first.item;
        first = first.next;
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
