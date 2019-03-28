package Forest.AnimalInterfaces

import Forest.FieldCell
import kotlin.random.Random

interface FlyingCreature : Creature {
    override fun makeMove(
        field: List<List<FieldCell>>,
        pathfinding: Int,
        hunger: Int
    ) {
        if (Random.nextInt(0, 100) >= hunger)
            return

        val possibleEndpoints: MutableList<Pair<Int, Int>> = mutableListOf()
        val possibleEndpointsWithFood: MutableList<Pair<Int, Int>> = mutableListOf()

        (-2..2).map { dRow ->
            (-2..2).map { dCol ->
                if (field[row + dRow][col + dCol].hasFood()) possibleEndpointsWithFood += Pair(row + dRow, col + dCol)
                else possibleEndpoints += Pair(row + dRow, col + dCol)
            }
        }

        if (!possibleEndpoints.isEmpty() && Random.nextInt(0, 100) < pathfinding) {

        }
    }
}