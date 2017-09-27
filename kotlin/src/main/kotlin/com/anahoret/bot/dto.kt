package com.anahoret.bot

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class Board(
  val width: Int = 0,
  val height: Int = 0,
  @field:JsonProperty("figures_count") val figuresCount: Int = 0,
  val cells: Array<IntArray> = emptyArray()) {

  override fun toString(): String =
    "Board{width=$width, height=$height, figures_count=$figuresCount, cells=${Arrays.deepToString(cells)}}"
}

class ClientMove(val figure: Int = 0, val status: String = "Ok")

class Game(val id: String = "", val board: Board = Board()) {
  override fun toString(): String = "Game{id='$id', board=$board}"
}

class ServerMove(val figure: Int = 0, val color: Int = 0) {
  override fun toString(): String = "ServerMove{figure=$figure, color=$color}"
}

class ResponseStatus(val status: String = "ok")
