package com.orchid.scala.data

class TemperaturData extends Serializable {

    var year = "2012"
    var month = "1"
    var day = "0"
    var temreture = 1

    override def toString: String = {
        "year" + year + ", month" + month + ",day" + day + ":" + temreture.toString
    }
}
