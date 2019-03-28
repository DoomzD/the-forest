package Forest.AnimalInterfaces

import Forest.Enums.EFood
import Forest.Enums.ETreePart
import Forest.FieldCell
import kotlin.random.Random

interface ICreature {
    var row: Int
    var col: Int

    var animalCount: Int

    val food: Set<Pair<EFood, ETreePart>>

    fun makeMove(
        field: List<List<FieldCell>>,
        pathfinding: Int,
        hunger: Int
    ) {
        if (Random.nextInt(0, 100) >= hunger)
            return

        val possibleEndpoints: MutableList<Pair<Int, Int>> = mutableListOf()
        val possibleEndpointsWithFood: MutableList<Pair<Int, Int>> = mutableListOf()

        (-1..1).map { dRow ->
            (-1..1).map { dCol ->
                if (field[row + dRow][col + dCol].hasFood()) possibleEndpointsWithFood += Pair(row + dRow, col + dCol)
                else possibleEndpoints += Pair(row + dRow, col + dCol)
            }
        }

        val endpoint: Pair<Int, Int> =
            if (possibleEndpoints.isEmpty() ||
                !possibleEndpointsWithFood.isEmpty() && Random.nextInt(0, 100) < pathfinding)
                possibleEndpointsWithFood.random()
            else possibleEndpoints.random()

        row = endpoint.first
        col = endpoint.second
    }

    fun process(fieldCell: FieldCell) {
        // TODO: Add logic
    }

    private fun checkForFood(fieldCell: FieldCell): List<Pair<EFood, Int>> =
        fieldCell.getFood().map {
            if (it.key in food) Pair(it.key.first, it.value) else Pair(it.key.first, 0)
        }.filter { it.second > 0 }
}