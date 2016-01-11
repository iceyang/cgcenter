package net.iceyang.service

import reactivemongo.api._
import reactivemongo.core.nodeset._
import scala.concurrent.ExecutionContext.Implicits.global

case class MongoConfig(
  host: String,
  port: Int,
  dbName: String,
  username: String,
  password: String
)

class Mongo(connection: MongoConnection) {
  def db(name: String): DefaultDB = connection(name)
}

object Mongo {
  def apply(connection: MongoConnection) = new Mongo(connection)

  def apply(mongoConfig: MongoConfig): Mongo = {
    val driver = new MongoDriver
    val server = s"${mongoConfig.host}:${mongoConfig.port}"
    if (mongoConfig.username != null && mongoConfig.username != "") {
      val credentials = List(Authenticate(mongoConfig.dbName, mongoConfig.username, mongoConfig.password))
      val connection = driver.connection(List(server), authentications = credentials)
      Mongo(connection)
    } else {
      val connection = driver.connection(List(server))
      Mongo(connection)
    }
  }

  def apply(host: String, port: Int): Mongo = Mongo(MongoConfig(host, port, "", "", ""))

  def apply(): Mongo = Mongo("127.0.0.1", 27017)
}
