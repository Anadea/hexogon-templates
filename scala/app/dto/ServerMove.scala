package dto

import play.api.libs.json.Json

object ServerMove {

  implicit val format = Json.format[ServerMove]

}

case class ServerMove(figure: Int, color: Int)
