package com.wxx.part1;

import sun.reflect.generics.visitor.Reifier

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

    val double_array:Array<Double> = arrayOf(2.0,4.011)
    setArrayNumInLine(double_array)


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
    return str;
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