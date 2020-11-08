package com.orchid.scala.grammar.algorithm

object SortedLine {

  /**
    * nums是由0，1，2构成的数组
    * 使用常量空间进行排序
    * @param nums
    * @return
    */
  def sortedList(nums: Array[Int]): Array[Int] = {
    val numLen = nums.length
    if (numLen == 0 || numLen == 1) {
      nums
    } else {
      var l:Int = 0
      var t:Int = 0
      var r: Int = numLen - 1
      while(t <= r) {
        if(nums(t) == 1) {
          t += 1
        } else if(nums(t) == 0) {
          if(nums(l) == 0) {
            t += 1
            l += 1
          } else {
            nums(l) = 0
            nums(t) = 1
            t += 1
            l += 1
          }
        } else {
          while(nums(r) == 2 && r > t) {
            r -= 1
          }
          nums(t) = nums(r)
          nums(r) = 2
          r -= 1
        }
      }
      nums
    }
  }

}
