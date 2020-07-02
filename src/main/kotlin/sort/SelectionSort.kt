package sort

/**sort
 * Created by hefuduo on 6/30/20.
 */
class SelectionSort {
    companion object {
        public fun <T> sort(a: Array<Comparable<T>>) {
            val n = a.size
            var min = 0
            for (i in 0 until n) {
                for (j in i + 1 until n) {
                    if (a[j] < a[min] as T) {
                        min = j
                    }
                }
                swap(a, i, min)
            }
        }

        public fun <T> swap(a: Array<Comparable<T>>, i: Int, j: Int) {
            val temp = a[i]
            a[i] = a[j]
            a[j] = temp
        }
    }
}
