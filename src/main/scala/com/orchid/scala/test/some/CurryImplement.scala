package com.orchid.scala.test.some

import com.orchid.scala.test.traits.Curry

import scala.io.Source

/**
  * @auther hugh Chen 
  *         created on 2021/3/18 11:47
  */
object CurryImplement extends Curry {
    /**
      * 柯里化 接受多个参数的函数变换成接受一个单一参数(最初函数的第一个参数)的函数，并且返回接受余下的参数且返回结果的新函数的技术。
      * 那么z也可以写成这样：def z=(x:Int)=>(y:Int)=>x+y
      * 实际实现是scala的语法糖，依次调用两个普通函数，第一次调用函数（x）,第二次调用时使用了(x)的返回值。
      *
      * def add=(x:Int)=>(y:Int)=>x+y
      *
      * @param f
      * @tparam A
      * @tparam B
      * @tparam C
      * @return
      */
    override def curry[A, B, C](f: (A, B) => C): A => B => C = { (a: A) => { b: B => f(a, b)}}

    override def uncurry[A, B, C](f: A => B => C): (A, B) => C = { (a: A, b: B) => f(a)(b)}
}

object CurryingHigherOrderFunction {

    def getData(data: String): Either[String, Source] =
        if (data == "dd")
            Left("ddd")
        else
            Right(Source.fromString(data))


    def main(args: Array[String]): Unit = {
        def add(x: Int, y: Long): Double = x.toDouble + y
        val addSpicy = CurryImplement.curry(add)
        println(addSpicy(3)(1L))
    }
}
