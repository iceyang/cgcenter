package net.iceyang.model

import reactivemongo.bson.{BSON, BSONHandler, BSONDateTime, BSONDocument, BSONDocumentReader, BSONDocumentWriter, BSONString}
import com.github.nscala_time.time.Imports._
import org.joda.time.format.ISODateTimeFormat

object Implicits {
  implicit object BSONDateTimeHandler extends BSONHandler[BSONDateTime, DateTime] {
    var fmt = ISODateTimeFormat.dateTime()
    def write(time: DateTime) = BSONDateTime(time.getMillis)
    def read(time: BSONDateTime) = new DateTime(time.value)
  }
}
