package union_find

import java.lang.IllegalArgumentException

/**union_find
 * Created by hefuduo on 6/29/20.
 * 带有权重与高度的QuickUnion
 */
class UFWeightedQuickUnionByHeight : UFAbstract {

    private lateinit var parent: IntArray  // parent[i] parent of i
    private lateinit var height: IntArray // height[i] height of subtree rooted at i

    constructor(n: Int) : super(n) {
        count = n //初始化为n个向量
        parent = IntArray(n)
        for (i in 0 until n) {
            parent[i] = i //初始化向量,每个向量的parent是它本身
            height[i] = 0
        }
    }

    constructor(id: IntArray) : super(id) {}


    private fun validate(p: Int) {
        val n = parent.size
        if (p < 0 || p >= n) {
            throw IllegalArgumentException("index $p is not between 0 and ${n - 1}")
        }
    }

    override fun union(p: Int, q: Int) {
        val i = find(p)
        val j = find(q)
        if (i == j) //同一组
            return
        if (height[i] < height[j]) {
            parent[i] = j //i的高度小于j,I的父节点设置为j
        } else if (height[i] > height[j]) {
            parent[j] = i //反之
        } else {
            parent[j] = i //如果两树高度相等
            height[i]++ //根节点高度+ 1;
        }
        count--
    }

    override fun find(p: Int): Int {
        validate(p)
        var tempP = p
        while (tempP != parent[tempP])
            tempP = parent[tempP]
        return tempP
    }
}
