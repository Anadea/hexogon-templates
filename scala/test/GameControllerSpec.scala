import controllers.api.GameController
import org.junit.runner._
import org.specs2.mutable._
import org.specs2.runner._
import play.api.libs.json._
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test._

@RunWith(classOf[JUnitRunner])
class GameControllerSpec extends Specification {

  "GameController" should {

    "return 0 on make move" in new WithApplication{
      val controller = new GameController(Helpers.stubControllerComponents())
      private val fakeRequest = FakeRequest(
        method = "GET",
        path = "/games/1?color=0")
      val result = controller.makeMove("1").apply(fakeRequest)
      val bodyText: JsValue = contentAsJson(result)
      val expected: JsValue = Json.obj("status" -> "ok", "figure" -> 0)
      bodyText must ===(expected)
    }

  }

}
