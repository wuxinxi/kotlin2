package com.wxx.part1

/**
 * 作者：wuxinxi on 2019/10/26
 * 包名：com.wxx.part1
 * TODO:函数
 */


fun main() {
    println(getName("wuxinxi", 25))
    println(getName2("wuxinxi", address = "安徽亳州"))
    println(getName3("wuxinxi",25,"安徽亳州","亳州三中"))
}


/**
 * 入参
 * 参数返回（）：类型
 */
fun getName(name: String, age: Int): String {
    return "name=$name,age=$age"
}

/**
 * 增加默认值
 */
fun getName2(name: String, age: Int = 26, address: String = "亳州"): String {
    return "name=$name,age=$age,address=$address"
}

/**
 * 增加可变参数
 * vararg关键字
 * 注意：如果有默认值此时也要给值否则会按照顺序传参
 */
fun getName3(name: String, age: Int = 26, address: String = "亳州", vararg args: String): String {
    var info = "name=$name,age=$age,address=$address"
    for (item in args) {
        info = "$info,$item"
    }
    return info
}