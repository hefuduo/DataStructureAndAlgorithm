package union_find

/**union_find
 * Created by hefuduo on 6/29/20.
 * quick-union算法,提高union算法的效率. 森林表示法,
 */
class UFQuickUnion : UFAbstract {

    constructor(n: Int) : super(n)
    constructor(id: IntArray) : super(id)

    override fun union(p: Int, q: Int) {
        val pRoot = find(p)
        val qRoot = find(q)
        if (pRoot == qRoot)
            return
        id[pRoot] = qRoot; //pRoot的根变为qRoot的根,将两个根连接起来
        count--
    }

    override fun find(p: Int): Int {
        var tempP = p
        while (tempP != id[tempP])
            tempP = id[tempP] //找到p的根节点.
        return tempP
    }
}
