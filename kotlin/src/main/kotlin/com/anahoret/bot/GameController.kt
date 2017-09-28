package com.anahoret.bot

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("games")
class GameController {

  @PostMapping
  @ResponseBody
  fun startGame(@RequestBody game: Game): ResponseStatus {
    println("startGame endpoint hit")
    println(game)

    return ResponseStatus("ok")
  }

  @GetMapping(value = "/{gameId}")
  @ResponseBody
  fun makeMove(@PathVariable("gameId") gameId: String, @RequestParam("color") color: Int): ClientMove {
    println("makeMove endpoint hit")
    println("gameId=" + gameId)
    println("color=" + color)

    return ClientMove(intArrayOf(0, 2), intArrayOf(0, 3))
  }

  @PutMapping(value = "/{gameId}")
  @ResponseBody
  fun handleMove(@PathVariable("gameId") gameId: String, @RequestBody serverMove: ServerMove): ResponseStatus {
    println("handleMove endpoint hit")
    println("gameId=" + gameId)
    println(serverMove)

    return ResponseStatus("ok")
  }

  @DeleteMapping(value = "/{gameId}")
  @ResponseBody
  fun finishGame(@PathVariable("gameId") gameId: String): ResponseStatus {
    println("finishGame endpoint hit")
    println("gameId=" + gameId)

    return ResponseStatus("ok")
  }

}
