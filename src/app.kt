import Forest.Forest
import Forest.Config

fun main() {
    val game = Forest(Config(10, 10, 10..20, 0.1f))

    var currentIteration = 1
    while (!game.animals.isEmpty())
        game.makeIteration(currentIteration++)

    println("The forest is dead...")
}