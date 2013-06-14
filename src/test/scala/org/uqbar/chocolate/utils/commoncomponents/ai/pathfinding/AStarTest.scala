package org.uqbar.chocolate.utils.commoncomponents.ai.pathfinding

import junit.framework.Assert.assertEquals
import java.awt.Dimension
import java.util.Arrays
import java.util.Collection
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import org.uqbar.chocolate.core.collisions.CircularBoundingBox
import org.uqbar.chocolate.core.collisions.RectangularBoundingBox
import org.uqbar.chocolate.core.components.CollisionTestComponent
import org.junit.runners.Parameterized
import org.uqbar.chocolate.utils.commoncomponents.ai.pathfinding.Area._
import com.sun.org.apache.xalan.internal.xsltc.compiler.Include

// ****************************************************************
// ** AUXILIARS
// ****************************************************************

object Area {
	type Coordinate = (Int, Int)
	type Zone = (Coordinate, Char)

	val N = (0, -1)
	val S = (0, 1)
	val W = (-1, 0)
	val E = (1, 0)

	def apply(lines : String*) : Area = {
		val zones = for {
			y ← 0 to lines.size - 1
			x ← 0 to lines(y).size - 1
			c = lines(y).charAt(x)
		} yield ((x, y), c)

		new Area(zones)
	}
}
case class Area(zones : IndexedSeq[Zone]) {
	def apply(coord : Coordinate) = zones.filter(_._1 == coord)(0)

	def neighbors(coord : Coordinate) = zones map (_._1) filter (c ⇒ List(N, S, W, E) contains (c._1 - coord._1, c._2 - coord._2))

	def follow(start : Char)(end : Char)(path : Char) = {
		val paths = Set(end, path)

		var answer : List[Coordinate] = Nil

		def rFollow(from : Coordinate) : Unit = {
			val next = neighbors(from).filter(c ⇒ paths(this(c)._2) && !answer.contains(c))(0)
			this(next)._2 match {
				case `path` ⇒ {
					answer = next :: answer
					rFollow(next)
				}
				case `end` ⇒ answer = next :: answer
			}
		}

		if (start != end) rFollow(zones.filter(_._2 == start)(0)._1)
		answer.reverse
	}
}

// ****************************************************************
// ** TEST CASES
// ****************************************************************

object AStarTest {
	val area1 = Area(
		"       O O O   O",
		" O  O  OO       ",
		"      O        O",
		"   O        O  O",
		"  O   OO  O  O  ",
		"   O   O    O  O",
		"   O       O    ",
		"  O   O        O",
		" OO     O       ",
		"O      OOOOO    ",
		"OO    OO  O   O ",
		"       O    OO  ",
		" OO    O  OO    ",
		"  O OO    O     ",
		"    O    O O O  ",
		"     OO      O  "
	)

	@Parameters
	def parameters : java.util.List[Array[AnyRef]] = {
		Arrays.asList(
			Array(area1, Area(
				"A      O O O   O",
				" O  O  OO       ",
				"      O        O",
				"   O        O  O",
				"  O   OO  O  O  ",
				"   O   O    O  O",
				"   O       O    ",
				"  O   O        O",
				" OO     O       ",
				"O      OOOOO    ",
				"OO    OO  O   O ",
				"       O    OO  ",
				" OO    O  OO    ",
				"  O OO    O     ",
				"    O    O O O  ",
				"     OO      O  "
			)),

			Array(area1, Area(
				"A      O O O   O",
				"BO  O  OO       ",
				"      O        O",
				"   O        O  O",
				"  O   OO  O  O  ",
				"   O   O    O  O",
				"   O       O    ",
				"  O   O        O",
				" OO     O       ",
				"O      OOOOO    ",
				"OO    OO  O   O ",
				"       O    OO  ",
				" OO    O  OO    ",
				"  O OO    O     ",
				"    O    O O O  ",
				"     OO      O  "
			)),

			Array(area1, Area(
				"A..... O O O   O",
				" O  O. OO       ",
				"     .O        O",
				"   O .B     O  O",
				"  O   OO  O  O  ",
				"   O   O    O  O",
				"   O       O    ",
				"  O   O        O",
				" OO     O       ",
				"O      OOOOO    ",
				"OO    OO  O   O ",
				"       O    OO  ",
				" OO    O  OO    ",
				"  O OO    O     ",
				"    O    O O O  ",
				"     OO      O  "
			)),

			Array(area1, Area(
				"A...   O O O   O",
				" O .O  OO       ",
				"   .. O        O",
				"   O.       O  O",
				"  O . OO  O  O  ",
				"   O.  O    O  O",
				"   O.      O    ",
				"  O . O        O",
				" OO ..  O       ",
				"O    . OOOOO    ",
				"OO   .OO  O   O ",
				"     . O    OO  ",
				" OO  ..O  OO    ",
				"  O OO... OB.   ",
				"    O   .O O.O  ",
				"     OO .....O  "
			))
		)
	}
}

@RunWith(classOf[Parameterized])
class AStarTest(_area : AnyRef, _expected : AnyRef) {
	val area = _area.asInstanceOf[Area]
	val expected = _expected.asInstanceOf[Area]
	val from = expected.zones.filter(z ⇒ z._2 == 'A')(0)
	val to = expected.zones.find(z ⇒ z._2 == 'B').getOrElse(from)

	@Test
	def bestPathIsTheExpected {
		val bestPath = AStar[Coordinate](area.neighbors(_))((_, b) ⇒ area(b) match {
			case (_, 'O') ⇒ Int.MaxValue
			case (_, ' ') ⇒ 1
			case (_, n) ⇒ n.toInt
		})((a, b) ⇒ (a._1 - b._1).abs + (a._2 - b._2).abs)(from._1)(to._1)

		assertEquals(expected.follow(from._2)(to._2)('.'), bestPath)
	}
}