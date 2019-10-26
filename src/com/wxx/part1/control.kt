package com.wxx.part1

import kotlin.random.Random

/**
 * 作者：wuxinxi on 2019/10/26
 * 包名：com.wxx.part1
 * TODO:控制语句
 */

fun main() {
    //条件判断直接赋值
    val isOk = Random.nextBoolean()
    var msg = if (isOk) {
        "hana"
    } else {
        "hebe"
    }
    println(msg)
    //继续简化,去除大括号，kotlin没有三元运算符
    msg = if (isOk) "hana" else "hebe"
    println(msg)

    //多路分支
    /**
     * switch 被when取代
     * case 被->取代
     * 取消break,kotlin默认一个分支处理完自动跳出分支
     * default被else取代
     */
    val count = Random.nextInt(10)
    when (count) {
        0 -> println("abc")
        1 -> println("def")
        else -> println("gg")
    }

    //类型判断 instanceof 被is取代

    //Kotlin实现退出多重循环
    //@对标志位做个标记即可
    back@ for (i in 1..10) {
        for (j in 1..5) {
            if (j == 4) {
                break@back
            }
            println("i=$i,j=$j")
        }
    }

    //空安全
    var canNullStr: String? = null
    var notNullStr = ""
    println(canNullStr.isNullOrBlank())
    println(notNullStr.isBlank())

    //.?等价于 if(str!=null)str.length else null ,即如果为null 不抛出异常而是返回null
    var length_null: Int?
    length_null = canNullStr?.length
    println(length_null)

    //如果不让其返回null,则使用?:
    //如果为null返回默认-1
    length_null=canNullStr?.length?:-1
    println(length_null)

    //!!如果确定结果一定不为null则可以强制不判null,这样就需要我们自行处理
    //!!表示不做空判断，强制执行后面的表达式，如果为null，抛出异常
    canNullStr="一定不为null"
    println(canNullStr!!.length)

    /**
     * 空安全总结
     * 1. 声明变量实例时，在类型名称后面加？，表示该变量可以为null
     * 2. 调用变量时，在变量名称后加？，表示一旦变量为null则直接返回null而不是抛出异常
     * 3. 调用变量时，在变量名称后加？：，表示变量一旦为null，则返回：后的表达式
     * 4. 调用变量时，在变量名称后加！！，表示不做空判断，一旦为null,抛出异常
     */


    //等式判断
    /**
     * 结构相等：== ，结构不等！= ，在kotlin中也包含String
     * 引用相等：=== ，引用不相等！==
     * is in
     */

}
 