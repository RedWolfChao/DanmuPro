package com.redolf.danmupro

import java.util.*

object RandomUtil {
    /**
     * 生成一个0 到 count 之间的随机数
     * @param endNum
     * @return
     */
    fun getNum(endNum: Int): Int {
        if (endNum > 0) {
            val random = Random()
            return random.nextInt(endNum)
        }
        return 0
    }

    /**
     * 生成一个startNum 到 endNum之间的随机数(不包含endNum的随机数)
     * @param startNum
     * @param endNum
     * @return
     */
    fun getNum(startNum: Int, endNum: Int): Int {
        if (endNum > startNum) {
            val random = Random()
            return random.nextInt(endNum - startNum) + startNum
        }
        return 0
    }

}