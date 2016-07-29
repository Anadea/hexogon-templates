package dto

import play.api.libs.json.Json

object Game {

  implicit val format = Json.format[Game]

}

case class Game(id: String, board: Board) {
  override def toString: String = "Game{" + "id='" + id + '\'' + ", board=" + board + '}'

}
