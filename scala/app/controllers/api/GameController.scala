package controllers.api

import javax.inject.Inject

import dto.{ClientMove, Game, ResponseStatus, ServerMove}
import play.api.libs.json.{JsError, JsSuccess, JsValue, Json}
import play.api.mvc._

import scala.concurrent.Future

class GameController @Inject()(controllerComponents: ControllerComponents) extends AbstractController(controllerComponents) {

  def start: Action[JsValue] = Action.async(controllerComponents.parsers.json) { request =>
    request.body.validate[Game] match {
      case s: JsSuccess[Game] =>
        val game = s.get

        println(game)

        Future.successful(Ok(Json.toJson(ResponseStatus("ok"))))

      case _: JsError => Future.successful(BadRequest)
    }
  }

  def makeMove(gameId: String): Action[AnyContent] = Action.async { request =>
    request.getQueryString("color") match {
      case Some(c) =>
        val color = c.toInt
        val move = ClientMove(figure = 0)

        println("makeMove endpoint hit")
        println("gameId=" + gameId)
        println("color=" + color)

        Future.successful(Ok(Json.toJson(move)))

      case None => Future.successful(BadRequest)
    }
  }

  def handleMove(gameId: String): Action[JsValue] = Action.async(controllerComponents.parsers.json) { request =>
    request.body.validate[ServerMove] match {
      case s: JsSuccess[ServerMove] =>
        val serverMove = s.get

        println("handleMove endpoint hit")
        println("gameId=" + gameId)
        println(serverMove)

        Future.successful(Ok(Json.toJson(ResponseStatus("ok"))))

      case _: JsError => Future.successful(BadRequest)
    }
  }

  def finish(gameId: String): Action[AnyContent] = Action.async { _ =>
    System.out.println("finishGame endpoint hit")
    println("gameId=" + gameId)

    Future.successful(Ok(Json.toJson(ResponseStatus("ok"))))
  }
}
