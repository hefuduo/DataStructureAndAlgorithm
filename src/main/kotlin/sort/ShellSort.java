package sort;

/**
 * sort
 * Created by hefuduo on 6/30/20.
 */
public class ShellSort {
    public static <T> void sort(Comparable<T>[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) { //数组变为h有序 0, h, 2h, 3h .... kh.
                for (int j = i; j >= h && a[j].compareTo((T) a[j - h]) < 0; j -= h) {
//                    swap(j, j -h);
                }
            }
            h = h / 3;
        }
    }
}
