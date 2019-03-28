import Forest.Forest
import Forest.Config

fun main() {
    val game = Forest(
        Config(
            rows = 10,
            columns = 10,
            animalsCount = 10..20,
            foodProbability = 0.1f
        )
    )

    var currentIteration = 1
    while (!game.animals.isEmpty())
        game.makeIteration(currentIteration++)

    println("The forest is dead...")
}