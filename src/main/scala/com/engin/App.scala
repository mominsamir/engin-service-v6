package com.engin

import org.apache.spark.{SparkConf, SparkContext}

class App  {

    def execute(sc : SparkContext, args : Array[String]): Unit = {
      val col = sc.parallelize(0 to 100 by 5)
      val smp = col.sample(true, 4)
      val colCount = col.count
      val smpCount = smp.count

      println("orig count = " + colCount)
      println("sampled count = " + smpCount)
    }
}
