package com.wxx.part2;

/**
 * @author TangRen
 * @create 2019-10-28 20:21
 * @TODO:  类和对象
 */

/**
 * 一级构造函数
 */
class ClassDemo constructor(name: String, age: Int) {
    init {
        println("init ...${hashCode()}")
    }

    /**
     * 二级构造函数
     */
    constructor(name: String, age: Int, address: String) : this(name, age) {
        println("二级构造函数${hashCode()}")
    }
}


class ClassDemo2 {

    init {
        println("init...${hashCode()}")
    }

    constructor(name: String, age: Int) {
        println("二级构造函数${hashCode()}")
    }


    constructor(name: String, age: Int, address: String) {
        println("二级构造函数${hashCode()}")
    }

}

/**
 * 具有默认参数的构造函数
 */
class ClassDemo3 constructor(name: String, age: Int, address: String = "安徽亳州") {
    init {
        println("init...${hashCode()},$name,$age,$address")
    }

}


/**
 * 具有默认参数的构造函数
 * 添加了@JvmOverloads关键字java代码也可以使用默认参数
 */
class ClassDemo4 @JvmOverloads constructor(name: String, age: Int, address: String = "安徽亳州") {
    init {
        println("init...${hashCode()},$name,$age,$address")
    }

}


/**
 * 1. 添加var是为了声名参数也是一个可变属性，可以访问
 * 2. 添加val声名参数时一个不可变参数，可以访问
 * 3. 如果声名的参数与实际的参数名并非一一致或者类型不同则可以在内部声名属性
 */
class ClassDemo5 constructor(var name: String, val sex: Int = 0) {
    //非空成员属性必须在声名时或者初始化时进行赋值
    var sexName: String

    init {
        sexName = if (sex == 0) "男" else "女"
        println("init...${hashCode()},$name,$sex")
    }

    fun getParams(): String {
        return "$name,$sexName"
    }
}


class ClassDemo6 {

    /**
     * 半生对象
     * StaticDemo是ClassDemo6类的半生对象
     * 可以直接通过ClassDemo6.compute进行访问
     * 等同于java的static的静态方法
     */
    companion object StaticDemo {
        //静态属性
        val ERROR = "操作符错误"

        fun compute(n1: Int, n2: Int, c: String): String {
            var res = when (c) {
                "+" -> "n1 + n2=${n1 + n2}"
                "-" -> "n1 - n2=${n1 - n2}"
                "*" -> "n1 * n2=${n1 * n2}"
                "/" -> "n1 / n2=${n1 / n2}"
                else -> ERROR
            }
            return res
        }
    }
}

fun main() {
    val classDemo = ClassDemo("wuxinxi", 25)

    val classDemo_2 = ClassDemo("wuxinxi", 25, "安徽亳州谯城区")

    //Kotlin将一级构造函数设为了非必要，即类中可以有多个二级构造函数而不需要一级函数
    val classDemo2 = ClassDemo2("wuxinxi", 25)

    //创建一个具有默认参数的构造函数，但是java无法使用，需添加@JvmOverloads关键之ClassDemo4
    val classDemo3 = ClassDemo3("wuxinxi", 25)

    val classDemo5 = ClassDemo5("wuxinxi", 1)
    classDemo5.name = "haha"
    classDemo5.sexName = "保密"
    println(classDemo5.name)
    println(classDemo5.sexName)
    println(classDemo5.getParams())

    println(ClassDemo6.compute(2, 45, "*"))

    println(ClassDemo6.ERROR)

}