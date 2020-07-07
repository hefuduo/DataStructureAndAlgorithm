package sort;

/**
 * sort 自底向上的 mergeSort 递归的方式,由于数据量太大导致栈溢出问题,不如这种方式好.
 * Created by hefuduo on 7/2/20.
 */
public class MergeSortBU {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        int n = a.length;
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo + len < n; lo += 2 * len) {
                int mid = lo + len - 1;
                int hi = Math.min(lo + len - 1 + len, n - 1);// n-1 为特殊情况处理, 要保证hi 不大于数组的长度
                merge(a, aux, lo, mid, hi);
            }
        }
    }


    private static void merge(Comparable[] a, Comparable[] aux, int l, int mid, int h) {
        int i = l; // i <= mid
        int j = mid + 1; //j <= h
        int k = l;
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
