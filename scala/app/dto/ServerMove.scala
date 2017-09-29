package dto

import java.util
import scala.collection.convert.wrapAll._

import play.api.libs.json.Json

object ServerMove {

  implicit val format = Json.format[ServerMove]

}

case class ServerMove(
  jumps: Map[String, Int],
  changes: Array[Array[Int]]
) {
  override def toString: String =
    "ServerMove{" +
    "jumps=" + jumps +
    ", changes=" + util.Arrays.deepToString(changes.asInstanceOf[Array[AnyRef]])  + "}"
}
