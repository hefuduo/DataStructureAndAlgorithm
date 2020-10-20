package labuladong.tb

import java.util.*
import kotlin.collections.ArrayList

/**labuladong.tb
 * Created by hefuduo on 7/30/20.
 */
//回溯算法
public class BackTraceAlgorithm {
    var res = LinkedList<LinkedList<Int>>()

    fun permute(nums: IntArray): List<List<Int>> {
        val track = LinkedList<Int>()
        backTrace(nums, track)
        return res
    }

    /**
     * TODO可以不可以优化?
     *
     * @param nums
     * @param track
     */
    private fun backTrace(nums: IntArray, track: LinkedList<Int>) {
        if (track.size == nums.size) {
            res.add(LinkedList(track))
            return
        }
        for (i in nums) {
            if (track.contains(i))
                continue
            track.add(i)
            backTrace(nums, track)
            track.removeLast()
        }
    }
}

/**
 * N皇后问题
 *
 */
public class NQueenProblem(val n: Int) {
    companion object {
        const val EMPTY = "."
        const val QUEEN = "X"
    }

    private val res = LinkedList<Array<Array<String>>>()
    var track: Array<Array<String>> = Array(n) { Array(n) { EMPTY } }
    var row = 0

    fun queen() {
        backTrace(0)
    }

    /**
     * track 为小于nrow的已经放置好的路径 ?路径
     * 所有nrow下的col都是选择          ?选择列表
     * 当row到达最后一行的时候返回        ?结束条件
     * @param row
     */
    private fun backTrace(row: Int) {
        if (track.size == row) {
            val newTrack = Array(n) { Array(n) { EMPTY } }
            //deep copy.
            for (m in newTrack.indices) {
                for (n in newTrack[m].indices) {
                    newTrack[m][n] = track[m][n]
                }
            }
            res.add(newTrack)
            return
        }
        var k = row
        for (i in 0 until n) {
            if (!isValid(row, i)) //能不能做选择
                continue
            track[row][i] = QUEEN  //选
            backTrace(row + 1) //下一个决策
            track[row][i] = EMPTY //撤销选择
        }
    }

    /**
     * TODO能否在row col处放置皇后
     *
     * @param row
     * @param col
     * @return
     */
    private fun isValid(row: Int, col: Int):Boolean {
        var i = track.size-1 // 已经放了几行

        //检查列冲突
        for (j in 0..i) {
            if (track[j][col] == QUEEN) {
                return false
            }
        }

        //检查右上方 row-1 col+1 row-- col++
        var q0 = row -1
        var p0 = col + 1
        while (q0 >= 0 && p0 < n) {
            if (track[q0][p0] == QUEEN)
                return false
            q0--
            p0++
        }

        //检查左上方 row-1 col-1 row-- col--
        var q1 = row -1
        var p1 = col -1
        while (q1 >= 0 && p1 >= 0) {
            if (track[q1][p1] == QUEEN)
                return false
            q1--
            p1--
        }
        return true
    }

    fun fancyPrint() {
        println("the count of possibilities is ${res.size}")
        for (item in res) {
            println("========================")
            for (row in item){
                println(row.contentToString())
            }
            println("========================")
        }
    }

}


fun main() {
//    val algo = BackTraceAlgorithm()
//    algo.permute(intArrayOf(1, 2, 3))
//    println(algo.res)

    val queue = NQueenProblem(8)
    queue.queen()
    queue.fancyPrint()
}
