import union_find.UFQuickFind

/**
 * Created by hefuduo on 6/11/20.
 */
fun main(args: Array<String>) {
    val id = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val al = UFQuickFind(id)
    println(al.count())
}
