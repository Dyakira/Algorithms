package chapter2.PQ;

/**
 * Created by Dyakira on 2016/5/13.
 */
public class HeadBaseMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public HeadBaseMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null; //回收资源
        sink(1);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key q = pq[i];
        pq[i] = pq[j];
        pq[j] = q;
    }

    //向上交换 k > 1 .. 1才是根节点 注意顺序：less(k / 2, k)
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }


    //向下交换
    private void sink(int k) {
        //循环条件 k * 2 <= N
        while (k * 2 <= N) {
            int j = k * 2; //左子节点下标
            //j < N 保证如果只有左节点无右节点不会NullPoint
            if (j < N && less(j, j + 1)) {
                j++; //保证下标j对应值的为左右子节点中最大的
            }
            //小于最大的子节点表示需要交换
            if (less(k, j)) {
                exch(k, j);
                k = j;
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        HeadBaseMaxPQ<Integer> pq = new HeadBaseMaxPQ<Integer>(10);
        pq.insert(90);
        pq.insert(22);
        pq.insert(44);
        pq.insert(1);
        pq.insert(2);
        pq.insert(6);
        pq.insert(5);
        while (!pq.isEmpty())
            System.out.println(pq.delMax());
    }
}
