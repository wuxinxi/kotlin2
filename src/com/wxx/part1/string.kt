package com.wxx.part1

/**
 * 作者：wuxinxi on 2019/10/24
 * 包名：com.wxx.part1
 * TODO:字符串的操作
 */

var splitStr: String = "ab,cd,efw,uxi,nxi"

var str: String = splitStr[0].toString()

fun main() {
    print(str)
    val split = splitStr.split(",")
    for (item in split) {
        print(item+"\n")
    }

    print("慌得一批：$splitStr"+"300${'$'}$split")

}