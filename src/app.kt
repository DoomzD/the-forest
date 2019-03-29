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
    while (game.notOver) {
        game.makeIteration(currentIteration++)
        Thread.sleep(3000)
    }

    println("The forest is dead...")
}