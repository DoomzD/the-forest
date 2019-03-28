package Forest

import Forest.AnimalInterfaces.ICreature
import Forest.Animals.*
import Forest.Enums.EFood
import Forest.Enums.ETree
import Forest.Enums.EAnimal

import kotlin.math.min
import kotlin.random.Random
import kotlin.random.nextInt

class Forest(private val conf: Config) {
    private val animals: MutableList<ICreature> = mutableListOf()
    private val field: List<List<FieldCell>> = (1..conf.rows).map {
        List(conf.columns) {
            FieldCell(ETree.values()[Random.nextInt(ETree.values().size)])
        }
    }

    init {
        updateField()

        animals += Badger(Random.nextInt(conf.rows), Random.nextInt(conf.columns), Random.nextInt(conf.animalsCount))
        animals += Chipmunk(Random.nextInt(conf.rows), Random.nextInt(conf.columns), Random.nextInt(conf.animalsCount))
        animals += Squirrel(Random.nextInt(conf.rows), Random.nextInt(conf.columns), Random.nextInt(conf.animalsCount))
        animals += FlyingSquirrel(Random.nextInt(conf.rows), Random.nextInt(conf.columns), Random.nextInt(conf.animalsCount))
        animals += Woodpecker(Random.nextInt(conf.rows), Random.nextInt(conf.columns), Random.nextInt(conf.animalsCount))

        println("FOREST GENERATED\n")

        println("ANIMAL STATISTICS")
        animals.forEach { animal -> println("Animal: ${getAnimalName(animal.animalType)}, ${animal.animalCount} units") }

        println("\nTREES STATISTICS")
        // TODO: Someone add these info x)
    }

    fun makeIteration(currentIteration: Int) {
        animals.forEach { it.makeMove(field) }
        animals.forEach { processFood(field[it.row][it.col], it) }
        updateField()
        updateGeneration()
        createReport(currentIteration)
    }

    private fun processFood(fieldCell: FieldCell, animal: ICreature) {
        val eatable: List<Pair<EFood, Int>> = checkForFood(fieldCell, animal)

        var hungriness = animal.getGroupHungriness()
        val newFood: MutableList<Pair<EFood, Int>> = mutableListOf()
        for (foodUnit in eatable) {
            val foodValue = foodValues[foodUnit.first]
            val toEat = min((hungriness / foodValue!!).toInt(), foodUnit.second)

            newFood += Pair(foodUnit.first, foodUnit.second - toEat)
            animal.addFood(toEat * foodValue)
            hungriness -= foodValue * toEat / animal.animalCount
        }

        fieldCell.setFood(newFood)
    }

    private fun checkForFood(fieldCell: FieldCell, animal: ICreature): List<Pair<EFood, Int>> =
        fieldCell.getFood().map {
            if (it.key in animal.food) Pair(it.key, it.value) else Pair(it.key, 0)
        }.filter { it.second > 0 }

    private fun updateField() {
        field.forEach { row -> row.forEach { cell -> cell.update(conf.foodProbability) } }
    }

    private fun updateGeneration() {
        animals.forEach { animal -> animal.checkIfDead() }
    }

    private fun createReport(currentIteration: Int) {
        println("Generation $currentIteration report:\n${"-".repeat(15)}")

        println("ANIMALS ALIVE")
        animals.forEach { animal ->
            createReportAboutAnimal(animal)
            println()
        }

        println("FOOD STATISTICS")
        val food: MutableMap<EFood, Int> = mutableMapOf()
        field.map { row ->
            row.map { cell ->
                cell.getFood().forEach { foodUnit ->
                    food[foodUnit.key] =
                        if (food[foodUnit.key] != null) food[foodUnit.key]!! + foodUnit.value else foodUnit.value
                }
            }
        }
        food.forEach { foodUnit -> println("${getFoodName(foodUnit.key)}: ${foodUnit.value}") }
    }

    private fun createReportAboutAnimal(animal: ICreature) {
        println("Animal: ${getAnimalName(animal.animalType)}, ${animal.animalCount} units")
        println("Hungriness: [${animal.hungriness}/100]")
        println("Stamina: [${animal.stamina}/100]")
    }

    private fun getAnimalName(animalType: EAnimal): String = when (animalType) {
        EAnimal.BADGER -> "Badger"
        EAnimal.CHIPMUNK -> "Chipmunk"
        EAnimal.SQUIRREL -> "Squirrel"
        EAnimal.FLYING_SQUIRREL -> "Flying Squirrel"
        EAnimal.WOODPECKER -> "Woodpecker"
    }

    private fun getFoodName(foodType: EFood): String = when (foodType) {
        EFood.NUTS -> "Nuts"
        EFood.MAPLE_LEAVES -> "Maple leaves"
        EFood.CONES -> "Cones"
        EFood.ROOT_VEGETABLES -> "Root vegetables"
        EFood.WORMS -> "Worms"
    }

    private fun getTreeName(treeType: ETree): String = when (treeType) {
        ETree.PINE -> "Pine"
        ETree.MAPLE -> "Maple"
        ETree.FIR -> "Fir"
        ETree.BIRCH -> "Birch"
        ETree.OAK -> "Oak"
        ETree.WALNUT -> "Walnut"
    }

    fun notOver(): Boolean = !animals.isEmpty()

    companion object {
        private val foodValues: Map<EFood, Int> = mapOf(
            Pair(EFood.ROOT_VEGETABLES, 5),
            Pair(EFood.CONES, 3),
            Pair(EFood.MAPLE_LEAVES, 2),
            Pair(EFood.NUTS, 5),
            Pair(EFood.WORMS, 7)
        )
    }
}