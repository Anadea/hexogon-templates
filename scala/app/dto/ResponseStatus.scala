package dto

import play.api.libs.json.Json

object ResponseStatus {

  implicit val format = Json.format[ResponseStatus]

}

case class ResponseStatus(status: String)
