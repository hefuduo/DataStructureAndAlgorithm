package union_find

/**union_find
 * Created by hefuduo on 6/29/20.
 */
class UFPathCompressQuickUnion : UFAbstract {

    constructor(n: Int) : super(n)

    constructor(id: IntArray) : super(id)

    override fun union(p: Int, q: Int) {
        val rootP = find(p)
        val rootQ = find(q)
        if (rootP == rootQ)
            return
        else
            id[rootP] = rootQ
        count--
    }

    /**
     * 在遍历p的节点的同时,将P的经过的节点全部指向根节点,即压缩路径.
     *
     * @param p
     * @return
     */
    override fun find(p: Int): Int {
        var root = p
        while (root != id[root])
            root = id[root] //找到p的root节点

        var tempP = p
        while (tempP != root) {
            val newP = id[tempP] //暂存P的父节点
            id[tempP] = root //将p指向root节点(P的父节点现在是root)
            tempP = newP
        }
        return root
    }
}
