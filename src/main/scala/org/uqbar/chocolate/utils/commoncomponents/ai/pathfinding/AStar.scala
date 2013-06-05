package org.uqbar.chocolate.utils.commoncomponents.ai.pathfinding

import scala.collection.mutable.Set
import scala.collection.mutable.Map

object AStar {
	def apply[T](neighbors : T ⇒ Traversable[T])(translationCost : (T, T) ⇒ Double = ((a : T, b : T) ⇒ 1))(heuristicCost : (T, T) ⇒ Double)(start : T)(goal : T) : List[T] = {
		val closed = Set[T]()
		val open = Set(start)
		val parents = Map[T, T]()
		val bestCost = Map[T, Double]()
		val bestFullCost = Map[T, Double]()

		def reconstructPath(goal : T) : List[T] = parents.get(goal) match {
			case Some(parent) ⇒ reconstructPath(parent) ::: List(goal)
			case None ⇒ Nil
		}

		bestCost(start) = 0
		bestFullCost(start) = bestCost(start) + heuristicCost(start, goal)

		while (!open.isEmpty) {
			val current = open.minBy(bestFullCost)
			if (current == goal) return reconstructPath(current)

			open -= current
			closed += current

			for {
				neighbor ← neighbors(current)
				tentative_g_score = bestCost(current) + translationCost(current, neighbor)
				if (!closed(neighbor) || tentative_g_score < bestCost(neighbor))
				if (!open(neighbor) || tentative_g_score < bestCost(neighbor))
			} {
				parents(neighbor) = current
				bestCost(neighbor) = tentative_g_score
				bestFullCost(neighbor) = bestCost(neighbor) + heuristicCost(neighbor, goal)

				open += neighbor
			}
		}

		throw new RuntimeException("No possible path found!")
	}
}