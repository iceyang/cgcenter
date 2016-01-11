package net.iceyang.model

import com.github.nscala_time.time.Imports._

object SendWay extends Enumeration {
  val Express, NoExpress = Value
}

case class Record(
  val id: String,
  val sendWay: SendWay.Value,
  val time: DateTime,
  val expressNum: String,
  val expressPrice: Int,
  val goodList: Array[GoodRecord]
)
