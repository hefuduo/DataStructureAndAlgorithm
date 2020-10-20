package queue


/**queue
 * Created by hefuduo on 7/6/20.
 */
interface Queue<T : Comparable<T>>: Iterable<T> {
    fun insert(v: T)
    fun max(): T
    fun delMax(): T
    fun isEmpty(): Boolean
}


class QueueImpl<T: Comparable<T>> : Queue<T>{
    override fun insert(v: T) {
        TODO("Not yet implemented")
    }

    override fun max(): T {
        TODO("Not yet implemented")
    }

    override fun delMax(): T {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }

}
