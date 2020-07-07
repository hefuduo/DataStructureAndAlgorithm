package queue


/**queue
 * Created by hefuduo on 7/6/20.
 */
interface Queue<T : Comparable<T>> {
    fun insert(v: T)
    fun max(): T
    fun delMax(): T
    fun isEmpty(): Boolean
}
