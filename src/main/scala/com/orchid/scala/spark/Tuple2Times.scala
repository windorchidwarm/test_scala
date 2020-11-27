package com.orchid.scala.spark

import com.orchid.scala.data.TemperaturData
import com.orchid.scala.utils.SecondarySort
import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaRDD
import org.apache.spark.sql.SparkSession

object Tuple2Times {

    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf()
            .setAppName("One_Hot_Encode")
            .setMaster("local")
            .set("spark.sql.warehouse.dir", "file:///E:/bigdata_work/spark_work/spark-warehouse")

        val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        val dataJavaRDD:JavaRDD[TemperaturData] = sparkSession.read.textFile("file:///C:/Users/BBD/Desktop/test/txt/temprate.txt")
            .toJavaRDD.filter(x => x != "").map(x => {
            val datas = x.split(",")
            val temp = new TemperaturData()
            temp.year = datas.apply(0)
            temp.month = datas.apply(1)
            temp.day = datas.apply(2)
            temp.temreture = datas.apply(3).toInt
            temp
        })

        dataJavaRDD.foreach(println)

        val sorTedRdd = dataJavaRDD.rdd
            .map(x => (new SecondarySort((x.year + x.month).toInt, x.temreture), x))
            .sortByKey()
            .toJavaRDD()
        sorTedRdd.foreach(println)

        val outRdd = sorTedRdd.groupBy(f => f._2.year + f._2.month).map( f => {
            var temperaturList = List[Int]()
            f._2.forEach(x => temperaturList = temperaturList :+ x._2.temreture)
            (f._1, temperaturList)
        })
        outRdd.foreach(println)


//        val pairWithSortKey = dataJavaRDD
//            .map(x => (new SecondarySort((x.year + x.month).toInt, x.temreture), x))
//            .rdd()


    }

}
