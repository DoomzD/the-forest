package Forest.AnimalInterfaces

import Forest.FieldCell
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

interface IFlyingCreature : ICreature {
    override fun makeMove(field: List<List<FieldCell>>) {
        if (Random.nextInt(0, 100) >= hungriness)
            return

        val possibleEndpoints: MutableList<Pair<Int, Int>> = mutableListOf()
        val possibleEndpointsWithFood: MutableList<Pair<Int, Int>> = mutableListOf()

        (max(-2, -row)..min(2, field.size - row - 1)).map { dRow ->
            (max(-2, -col)..min(2, field[0].size - col - 1)).map { dCol ->
                if (field[row + dRow][col + dCol].hasFood()) possibleEndpointsWithFood += Pair(row + dRow, col + dCol)
                else possibleEndpoints += Pair(row + dRow, col + dCol)
            }
        }

        var endpoint: Pair<Int, Int> =
            if (possibleEndpoints.isEmpty() ||
                !possibleEndpointsWithFood.isEmpty() && Random.nextInt(0, 20) < skills.pathfinding.getMultiplier()
            )
                possibleEndpointsWithFood.random()
            else possibleEndpoints.random()

        var dist: Int = abs(endpoint.first - row) + abs(endpoint.second - col)
        if (dist > stamina)
            endpoint = Pair(row, col).also { dist = 0 }
        stamina -= if (dist > 0) dist else -4
        hungriness += dist

        row = endpoint.first
        col = endpoint.second
    }
}