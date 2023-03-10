package com.engin

import org.apache.spark.SparkContext

class App  {

    def execute(sc : SparkContext): Unit = {
      val col = sc.parallelize(0 to 100 by 5)
      val smp = col.sample(true, 4)
      val colCount = col.count
      val smpCount = smp.count

      println("orig count = " + colCount)
      println("sampled count = " + smpCount)
    }
}
