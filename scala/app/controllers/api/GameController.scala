package controllers.api

import dto.{ClientMove, Game, ResponseStatus, ServerMove}
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc._


class GameController extends Controller {

  def start = Action(BodyParsers.parse.json) { request =>
    request.body.validate[Game] match {
      case s: JsSuccess[Game] =>
        val game = s.get

        println(game)

        Ok(Json.toJson(ResponseStatus("ok")))

      case e: JsError => BadRequest
    }
  }

  def makeMove(gameId: String) = Action { request =>
    request.getQueryString("color") match {
      case Some(c) =>
        val color = c.toInt
        val move = ClientMove(figure = 0)

        println("makeMove endpoint hit")
        println("gameId=" + gameId)
        println("color=" + color)

        Ok(Json.toJson(move))

      case None => BadRequest
    }
  }

  def handleMove(gameId: String) = Action(BodyParsers.parse.json) { request =>
    request.body.validate[ServerMove] match {
      case s: JsSuccess[ServerMove] =>
        val serverMove = s.get

        println("handleMove endpoint hit")
        println("gameId=" + gameId)
        println(serverMove)

        Ok(Json.toJson(ResponseStatus("ok")))

      case e: JsError => BadRequest
    }
  }

  def finish(gameId: String) = Action { request =>
    System.out.println("finishGame endpoint hit")
    println("gameId=" + gameId)

    Ok(Json.toJson(ResponseStatus("ok")))
  }
}
