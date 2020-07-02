package sort;

/**
 * sort
 * Created by hefuduo on 6/30/20.
 */
public class InsertSort {
    public static <T> void sort(Comparable<T>[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j >= 0; j--) {
                if (a[j].compareTo((T) a[i]) < 0) {
//                    swap(i, j);
                }
            }
        }
    }
}
