package chapter2;

/**
 * Created by Dyakira on 2016/4/7.
 */
public class Selection extends SortBase {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
                exch(a, i, min);
            }
        }
    }

    public static void main(String[] args) {
        String[] a = "S O R T E X A M P L E".split(" ");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
