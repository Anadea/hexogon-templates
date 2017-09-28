package dto

import play.api.libs.json.Json

object Game {

  implicit val format = Json.format[Game]

}

case class Game(
  id: String,
  first_turn: Boolean,
  training: Boolean,
  board: Board
) {
  override def toString: String =
    "Game{" + "id='" + id + '\'' +
    ", first_turn=" + first_turn +
    ", training=" + training +
    ", board=" + board + '}'
}
