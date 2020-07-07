package queue;

/**
 * 堆排序
 * Created by hefuduo on 7/6/20.
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            buildMaxHeap(arr, i);
            swap(arr, 0, i);
        }
    }

    /**
     * 树根从0开始返回root左孩子
     *
     * @param root
     * @return
     */
    public static int left(int root) {
        return 2 * root + 1;
    }

    /**
     * 树根从0开始返回root的右孩子
     *
     * @param root
     * @return
     */
    public static int right(int root) {
        return 2 * root + 2;
    }

    /**
     * 返回叶子节点的根节点
     *
     * @param leaf
     * @return
     */
    public static int parent(int leaf) {
        if (leaf == 0) {
            return -1;
        } else {
            return (leaf - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 建立大顶堆
     *
     * @param leaf
     */
    public static void buildMaxHeap(int[] arr, int leaf) {
        int root = parent(leaf);
        for (int j = root; j >= 0; j--) {
            maxHeap(arr, root, leaf);
        }
    }


    /**
     * 在跟节点建立大顶堆.
     *
     * @param root
     * @param w    watcher
     */
    public static void maxHeap(int[] arr, int root, int w) {
        int l = left(root);
        int r = right(root);
        int max = root;
        if (l <= w && arr[l] > arr[root]) {
            max = l;
        } else if (r <= w && arr[r] > arr[root])
            max = r;

        if (max != root) {
            swap(arr, max, root);
            maxHeap(arr, max, w);
        }
    }
}
