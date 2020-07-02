package union_find

/**union_find
 * Created by hefuduo on 6/29/20.
 */
class UFWeightedQuickUnionWithPathCompress : UFWeightedQuickUnion {
    constructor(n: Int) : super(n)

    constructor(id: IntArray) : super(id)

    override fun union(p: Int, q: Int) {
        val i = find(p)
        val j = find(q)
        if (sz[i] < sz[j]) {
            id[i] = j
            sz[j] += sz[i]
        } else {
            id[j] = i
            sz[i] += sz[j]
        }
    }

    override fun find(p: Int): Int {
        var root = p
        while (root != id[root])
            root = id[root]

        var tempP = p
        while (tempP != id[tempP]) {
            val newP = id[tempP]
            id[tempP] = root
            tempP = newP
        }
        return root
    }
}
