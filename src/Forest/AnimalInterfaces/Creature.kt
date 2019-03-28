package Forest.AnimalInterfaces

import Forest.Enums.EAnimal
import Forest.Enums.EFood
import Forest.FieldCell

import RPG.IAnimalCharacteristics
import RPG.ISkills

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

interface ICreature : IAnimalCharacteristics, ISkills {
    val animalType: EAnimal

    var row: Int
    var col: Int

    var animalCount: Int

    var stamina: Float
    var hungriness: Float

    val food: Set<EFood>

    fun makeMove(field: List<List<FieldCell>>) {
        if (Random.nextInt(0, 100) >= hungriness)
            return

        val possibleEndpoints: MutableList<Pair<Int, Int>> = mutableListOf()
        val possibleEndpointsWithFood: MutableList<Pair<Int, Int>> = mutableListOf()

        (max(-1, -row)..min(1, field.size - row - 1)).map { dRow ->
            (max(-1, -col)..min(1, field[0].size - col - 1)).map { dCol ->
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
        hungriness = min(100f, hungriness + dist)

        row = endpoint.first
        col = endpoint.second
    }

    fun getGroupHungriness() = hungriness * animalCount

    fun addFood(foodPoints: Int) {
        hungriness -= foodPoints / animalCount
    }

    fun checkIfDead() {
        if (hungriness == 100f)
            animalCount -= 1
    }
}