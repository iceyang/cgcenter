package net.iceyang.model

case class Customer(
  val id: String,
  val name: String,
  val phone: String,
  val address: Array[String],
  val records: Array[Record]
)
