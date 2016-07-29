package dto

import java.util
import scala.collection.convert.wrapAll._

import play.api.libs.json.Json

object Board {

  implicit val format = Json.format[Board]

}

case class Board(width: Int, height: Int, figures_count: Int, cells: Array[Array[Int]]) {
  override def toString: String =
    "Board{" + "width=" + width + ", height=" + height +
    ", figures_count=" + figures_count +
    ", cells=" + util.Arrays.deepToString(cells.asInstanceOf[Array[AnyRef]])  + "}"

}
