package dto

import play.api.libs.json.Json

object ClientMove {

  implicit val format = Json.format[ClientMove]

}

case class ClientMove(status: String = "ok", figure: Int)
