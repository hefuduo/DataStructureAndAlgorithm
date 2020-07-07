package sort;

import java.util.Arrays;

/**
 * sort  自顶向下的merge sort
 * Created by hefuduo on 7/2/20.
 */
public class MergeSort {
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];

    }


    private static void merge(Comparable[] a, Comparable[] aux, int l, int mid, int h) {
        int i = l; // i <= mid
        int j = mid + 1; //j <= h
        int k = l;  //TODO 另一种写法,可以用index比较的方式
        for (k = l; k <= h; k++) {
            if (a[i].compareTo(a[j]) < 0) {
                aux[k] = a[i];
                i++;
            } else {
                aux[k] = a[j];
                j++;
            }
        }
        while (i <= mid) {
            aux[k] = a[i];
            i++;
            k++;
        }
        while (j <= h) {
            aux[k] = a[j];
            j++;
            k++;
        }
        if (h + 1 - l >= 0) System.arraycopy(aux, l, a, l, h + 1 - l);
    }
}
