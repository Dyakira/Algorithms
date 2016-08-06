package chapter2;

/**
 * Created by Dyakira on 2016/5/6.
 */
public class Merge extends SortBase {
    private static Comparable[] aux; //辅助数组

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];//一次性分配空间
        sort(a, 0 ,a.length - 1);
    }


    private static void sort(Comparable[] a, int lo ,int hi ){
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);//将左半边排序
        sort(a, mid+1, hi);//将右半边排序
        merge(a, lo, mid , hi);//归并结果
    }

    //将a[lo..mid] 和 a[mid+1..hi]归并
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        //将[lo..hi]复制到aux[lo..hi];
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        //归并回到a[lo..hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];//左半边用尽（取右半边元素）
            } else if (j > hi) {
                a[k] = aux[i++];//右半边用尽（取左半边元素）
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];//右半边当前元素小于左半边当前元素（取右半边元素）
            } else {
                a[k] = aux[i++];//右半边的当前元素大于左半边当前元素（取左半边元素）
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
