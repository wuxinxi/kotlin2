package com.wxx.part1;

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.cos

/**
 * @author TangRen
 * @create 2019-10-27 19:12
 * @TODO:  特殊函数：泛型函数、内联函数、简化函数、尾递归函数、高阶函数
 */

fun main() {
    val listOf: List<String> = listOf("abc", "efg", "hij")
    val appendString = appendString("wuxinxi", "haha")
    println(appendString)

    val number_arry: Array<Number> = arrayOf(1, 2, 3, 4)
    setArrayNumber(number_arry)

    val int_array: Array<Int> = arrayOf(2, 3)
    setArrayNumInLine(int_array)

    val double_array: Array<Double> = arrayOf(2.0, 4.011)
    setArrayNumInLine(double_array)

    println("point=" + findFixPoint(20.0))

    var string_array: Array<String> = arrayOf("How", "do", "you", "I'm ", "Fine")
    println("max=${string_array.max()}")

    for (index in 0..3) {
        val msg = when (index % 4) {
            0 -> "字符串数组的默认最大值为：${string_array.max()}"
            1 -> "字符串数组按长度比较的最大值为${maxCustom(string_array) { a, b -> a.length > b.length }}"
            2 -> "字符串数据的默认最大值:${maxCustom(string_array) { a, b -> a > b }}"
            else -> "字符串数组按去掉空格在比较长度的最大值为${maxCustom(string_array) { a, b -> a.trim().length > b.trim().length }}"
        }
        println(msg)
    }

    println("当前时间：${Date().getNowDateTime()}")
    println("当前自定义时间：${Date().getFormatTime("HH:mm:ss:SSS")}")

    println("单例->当前时间:${DateUtil.nowDateTime}")
    println("单例->当前自定义时间:${DateUtil.getCustomFormatTime()}")


}


/**
 * 泛型函数
 *
 */
fun <T> appendString(tag: String, vararg otherInfo: T?): String {
    var str = "$tag:"
    for (item in otherInfo) {
        str = "$str${item.toString()}"
    }
    return str
}


/**
 * 虽然Int、Double继承自Number但是此处还是不允许传入
 */
fun setArrayNumber(array: Array<Number>) {
    for (item in array) {
        println(item.toString())
    }
}

/**
 * 内联函数
 * 此时就可以传入Int,Double
 */
inline fun <reified T : Number> setArrayNumInLine(array: Array<T>) {
    for (item in array) {
        println(item.toString())
    }
}

/**
 * 阶乘计算
 */
fun factorial(n: Int): Int {
    return if (n <= 1) n
    else n * factorial(n - 1)
}

/**
 * 简化函数
 * 阶乘计算进行简化
 * 等号后面直接跟表达式
 */
fun factoral2(n: Int): Int = if (n <= 1) n else n * factoral2(n - 1)

/**
 * 尾递归函数
 * 函数末尾的返回值重复调用自身函数，fun前加tailrec
 * 此时编译器会自动优化递归，用循环的方式代替递归，从而避免栈溢出的情况
 */
tailrec fun findFixPoint(x: Double = 1.0): Double =
    if (x == cos(x)) x else findFixPoint(cos(x))

/**
 * 高阶函数
 */
fun <T> maxCustom(array: Array<T>, greater: (T, T) -> Boolean): T? {
    var max: T? = null
    for (item in array) {
        if (max == null || greater(item, max)) {
            max = item
        }
    }
    return max
}


/**
 * 扩展方法
 * 扩展类.方法名即可进行类的扩展
 */
fun Date.getNowDateTime(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return sdf.format(this)
}

/**
 * 自定义格式
 */
fun Date.getFormatTime(format: String = "yyyy-MM-dd"): String {
    val sdf = SimpleDateFormat(format)
    return sdf.format(this)
}

/**
 * 单例对象
 * 日期工具类
 */
object DateUtil {
    val nowDateTime: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return sdf.format(Date())
        }

    fun getCustomFormatTime(format: String = "yyyy-MM-dd"): String {
        val sdf = SimpleDateFormat(format)
        return sdf.format(Date())
    }

}