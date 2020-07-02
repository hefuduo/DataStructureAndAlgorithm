package union_find

/*
 * 算法分析
 * find()操作时间复杂度O(1)
 * 但是uniond()操作时间复杂度O(n^2)
 *
 */


/**union_find
 * quick find algorithm
 * 使用数组,下标代表向量, 值代表分组
 * Created by hefuduo on 6/11/20.
 */
class UFQuickFind : UFAbstract {

    constructor(n: Int) : super(n)

    constructor(id: IntArray) : super(id)

    override fun union(p: Int, q: Int) {
        val pId = find(p)
        val qId = find(q)
        if (pId == qId)
            return
        for (i in id.indices) {
            if (id[i] == pId) {
                id[i] = qId
            }
        }
        count--
    }

    override fun find(p: Int): Int {
        return id[p]
    }
}

