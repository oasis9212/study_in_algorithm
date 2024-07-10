package stu_20240701

import com.sun.jdi.IntegerType
import java.util.Arrays


fun main(){
    val num=  intArrayOf(100, 1, 10)

    Arrays.sort(num)
    var min=Int.MAX_VALUE

    for(i in 0 until num.size - 1){
        val compareval=num[i+1] -num[i]
        min=Math.min(min,compareval)
    }
    println(min)

}
