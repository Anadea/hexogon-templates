package dto

import java.util
import scala.collection.convert.wrapAll._

import play.api.libs.json.Json

object ServerMove {

  implicit val format = Json.format[ServerMove]

}

case class ServerMove(changes: Array[Array[Int]]) {
  override def toString: String =
    "ServerMove{" +
      "changes=" + util.Arrays.deepToString(changes.asInstanceOf[Array[AnyRef]])  + "}"
}
