package chapter2.PQ;

/**
 * Created by Dyakira on 2016/5/13.
 */
public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    //初始化有序优先队列
    public OrderedArrayMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key key) {
        int i = N - 1;
        while (i >= 0 && less(key, pq[i])) {
            pq[i + 1] = pq[i]; //i+1 不是 i++
            i--;
        }
        pq[i + 1] = key;
        N++;
    }

    public Key delMax() {
        return pq[--N];
    }

    private boolean less(Key i, Key j) {
        return i.compareTo(j) < 0;
    }

}
