import java.util

import dto.Board

Board(100, 100, 3, Array(Array(1,2,3), Array(4,5,6))).toString

val a: AnyRef = Array(1,2,3)
val cells: Array[AnyRef] = Array(Array(1,2,3), Array(14,5,6))
util.Arrays.deepToString(cells)
