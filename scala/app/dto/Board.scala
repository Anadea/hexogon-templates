package dto

import java.util
import scala.collection.convert.wrapAll._

import play.api.libs.json.Json

object Board {

  implicit val format = Json.format[Board]

}

case class Board(size: Int, cells: Array[Array[Int]]) {
  override def toString: String =
    "Board{" + "size=" + size +
    ", cells=" + util.Arrays.deepToString(cells.asInstanceOf[Array[AnyRef]])  + "}"

}
