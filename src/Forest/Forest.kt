package Forest

import Forest.AnimalInterfaces.ICreature

class Forest(private val conf: Config) {
    val animals: MutableList<ICreature> = mutableListOf()

    fun makeIteration(currentIteration: Int) {
        TODO("Add logic")
    }
}