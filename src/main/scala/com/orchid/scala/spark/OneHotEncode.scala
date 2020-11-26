package com.orchid.scala.spark

import org.apache.spark.SparkConf

import org.apache.spark.sql.SparkSession

object OneHotEncode {

    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf()
            .setAppName("One_Hot_Encode")
            .setMaster("local")
            .set("spark.sql.warehouse.dir", "file:///E:/bigdata_work/spark_work/spark-warehouse")

        val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        val df = sparkSession.sqlContext.createDataFrame(Seq((1L, "foo"), (2L, "bar"))).toDF("id", "x")

        var categoricals = df.dtypes.filter(_._2 == "StringType").map(_._1)


//        val indexers = categoricals.map(c => new StringIndexer().setInputCol(s"${c}_idx").setOutputCol(s"${c}_enc"))
//
//        val encoders = categoricals.map(c => new OneHotEncoder().setInputCol(s"${c}_idx").setOutputCol(s"${c}_enc"))
//
//        val pipeline = new Pipeline().setStages(indexers ++ encoders)
//        val transformed = pipeline.fit(df).transform(df)
//        transformed.show

    }



}
