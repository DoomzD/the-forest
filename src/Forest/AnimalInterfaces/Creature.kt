package Forest.AnimalInterfaces

interface Creature {
    fun makeMove(
        possibleEndpoints: List<Pair<Int, Int>>,
        pathfinding: Int,
        hunger: Int
    ) {
        // TODO: Add logic
    }
}