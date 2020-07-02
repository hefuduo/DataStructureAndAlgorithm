package union_find

/**union_find
 * Created by hefuduo on 6/29/20.
 */
abstract class UFAbstract(n: Int) : UF {

    protected var id: IntArray //分量的id,下标代表量,值代表分组

    protected var count: Int = 1   //分组数量

    init {
        count = n
        id = IntArray(n)
    }

    constructor(id: IntArray) : this(id.size) {
        this.id = id
    }

    override fun connected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    override fun count(): Int {
        return count
    }
}
