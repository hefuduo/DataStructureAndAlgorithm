package union_find

/**union_find
 * Created by hefuduo on 6/29/20.
 * 带加权的QuickUnion
 */
open class UFWeightedQuickUnion : UFAbstract {

    lateinit var sz: IntArray //各个根节点的`分量`的大小, 初始化为1

    constructor(n: Int) : super(n) {
        for (i in 0 until n) {
            sz[i] = 1
        }
    }

    constructor(id: IntArray) : super(id) {
        for (i in id.indices) {
            sz[i] = 1
        }
    }

    override fun union(p: Int, q: Int) {
        var i = find(p)
        var j = find(q)
        if (i == j)
            return
        if (sz[i] < sz[j]) {
            id[i] = j //谁大谁做根节点
            sz[j] += sz[i]
        }else {
            id[j] = i
            sz[i] += sz[j]
        }
    }

    override fun find(p: Int): Int {
        var tempP = p
        while (tempP != id[tempP])
            tempP = id[tempP]
        return tempP
    }
}
