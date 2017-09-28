package com.anahoret.bot

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class Board(
  val size: Int = 0,
  val cells: Array<IntArray> = emptyArray()) {

  override fun toString(): String =
    "Board{size=$size, cells=${Arrays.deepToString(cells)}}"
}

class ClientMove(
  @field:JsonProperty("move_from") val moveFrom: IntArray = intArrayOf(),
  @field:JsonProperty("move_to") val moveTo: IntArray = intArrayOf(),
  val status: String = "ok")

class Game(
  val id: String = "",
  val training: Boolean = false,
  @field:JsonProperty("first_turn") val firstTurn: Boolean = false,
  val jumps: HashMap<String, Int> = hashMapOf(),

  val board: Board = Board()) {

  override fun toString(): String =
    "Game{id='$id', training=$training, first_turn=$firstTurn, jumps=$jumps, board=$board}"
}

class ServerMove(
  val jumps: HashMap<String, Int> = hashMapOf(),
  val changes: Array<IntArray> = emptyArray()) {

  override fun toString(): String =
    "ServerMove{jumps=$jumps, changes=${Arrays.deepToString(changes)}}"
}

class ResponseStatus(val status: String = "ok")
