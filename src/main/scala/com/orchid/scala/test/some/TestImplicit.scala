package com.orchid.scala.test.some

object TestImplicit {

    def main(args: Array[String]): Unit = {
        implicit def stringToInt(s: String) = s.toInt

        implicit val adder = "test"
        val ss = "test"
        println(s"ss = ${ss}")
        val t = new TestImplicit
        println(t.addTest(1, "2"))
        t.helloWord(2, implicitly)
    }
}

class TestImplicit {

    def helloWord(implicit a: Int, b: String) = println(a, b)

    def addTest(a: Int, b:Int) = a + b
}
