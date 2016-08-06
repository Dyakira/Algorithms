package chapter2;

/**
 * Created by Dyakira on 2016/4/7.
 */
public class SortBase {
    public static void sort(Comparable[] a){}
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    public static void exch(Comparable[] a,int i, int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }
    //单行打印数组
    public static void show(Comparable[] a ){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    //是否有序
    public static boolean isSorted(Comparable[] a ){
        for (int i = 0; i < a.length ; i++) {
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }

}
