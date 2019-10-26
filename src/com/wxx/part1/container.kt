package com.wxx.part1

/**
 * 作者：wuxinxi on 2019/10/24
 * 包名：com.wxx.part1
 * TODO: 只读容器 Map/List/Set
 * TODO 可变容器：MutableMap/MutableList/MutableSet
 * TODO 循环：for--in 迭代器、forEach
 */

/**
 * Set
 * 1. 容器内元素并非是排序的，因此无法用下标去获取
 * 2. 容器内元素不能够重复添加，通过hashcode判断是否存在相同的 值，如果存在则覆盖
 * Set仅可读，mutableSet可用于元素的变更，但是有一下限制
 * 1. 由于元素是无序的所以不能通过添加到具体位置
 * 2. MutableSet无法修改元素的值即一旦添加就无法修改
 * 3. remove仅能删除指定的元素而无法通过下标
 */
val family: Set<String> = setOf("father", "mather", "me")
var mutableSetFamily: MutableSet<String> = mutableSetOf()

/**
 * 比Set多了次序管理，对于增删改都必须由MutableList来处理
 * 与java相似
 */
val colors: List<String> = listOf("green", "gray", "red", "black")
var mutableListColors: MutableList<String> = mutableListOf("green", "gray", "white", "red", "pink", "black")

/**
 * 与java相似
 * 1. MutableMap 添加可用put以及["key"]="value"
 * 2. 初始化映射有两种方式：to 以及Pair(key,value)
 */
val satellites: Map<String, String> = mapOf("Earth" to "human", "Moon" to "mineral", "Venus" to "desert")
val mutableMapSatellites: MutableMap<String, String> = mutableMapOf(Pair("Earth", "human"))


fun main() {
    for (satellite in satellites) {
        println(satellite)
    }

    println("------------------Set for--in ------------------------")
    for (member in family) {
        println(member)
    }

    println("-----------------Set iterator迭代器-------------------------")
    val iterator = family.iterator();
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    println("-----------------Set forEach-------------------------")
    family.forEach {
        println(it)
    }

    mutableSetFamily.add("father")
    mutableSetFamily.add("mather")
    mutableSetFamily.add("me")
    mutableSetFamily.add("sister")
    mutableSetFamily.add("me")
    mutableSetFamily.forEach {
        println("可变的Set集合：$it")
    }

    println("-----------------List forEach-------------------------")
    colors.forEach {
        println(it)
    }

    println("-----------------List indices -------------------------")
    for (index in colors.indices) {
        println("$index=${colors[index]}")
    }
    println("-----------------List 升序排列 括号内为升序条件 -------------------------")
    //sortBy 升序
    //sortByDescending 降序
    mutableListColors.sortBy {
        it[0]//根据首字母进行排序
    }
    for (item in mutableListColors) {
        println(item)
    }

    println("-----------------Map for--in-------------------------")
    for (item in satellites) {
        println("key=${item.key},value=${item.value}")
    }

    mutableMapSatellites["moon"] = "mineral"

    println("-----------------Map forEach-------------------------")
    mutableMapSatellites.forEach { (t, u) ->
        println("key=$t,value=$u")
    }

    println("-----------------Map 迭代器-------------------------")

    val iterator2 = mutableMapSatellites.iterator()
    while (iterator2.hasNext()) {
        val item = iterator2.next();
        println("key=${item.key},value={${item.value}}")
    }
}





