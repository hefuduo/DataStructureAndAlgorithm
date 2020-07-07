package sort;

/**
 * sort
 * Created by hefuduo on 7/2/20.
 */
public class QuickSort {
    public static void sort(Comparable[] a) {

    }

    public static void sort(Comparable[] a, int lo, int hi) {
        int j = partion(a, lo, hi);//j is just in his place !!
        sort(a, lo, j-1);
        sort(a, j + 1, hi);
    }

    public static int partion(Comparable[] a, int lo, int hi) {
        int j = lo;
        int p = lo, q = hi;
        Comparable watcher = a[j];
        for (; ; ) {
            while (a[++p].compareTo(watcher) < 0) {
                if (p == hi)
                    break;
            }
            while (a[--q].compareTo(watcher) > 0) {
                if (q == lo)
                    break;
            }
            if (p > q)
                break;
//            swap(a,p, q );
        }

        return j;
    }
}
