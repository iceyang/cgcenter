package net.iceyang

import reactivemongo.bson._
import reactivemongo.api.collections.bson.BSONCollection
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{ Failure, Success }

import net.iceyang.db._
import com.github.nscala_time.time.Imports._

object Main {
  def test():Unit = {
    val mongoConfig = MongoConfig("localhost", 27017, "admin", "root", "admin")
    val mongo = Mongo(mongoConfig)
    val db = mongo.db("test")
    import net.iceyang.model.Implicits._
    val doc:BSONDocument = BSONDocument(
      "name" -> "iceyang",
      "time" -> new DateTime()
    )
    val coll = db[BSONCollection]("user")
    coll.insert(doc).onComplete {
      case Failure(e) => {
        throw e
      }
      case Success(writeResult) =>
    }
  }
}
