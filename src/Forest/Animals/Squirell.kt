package Forest.Animals

import Forest.AnimalInterfaces.ICreature
import Forest.Enums.EFood
import Forest.Enums.ETreePart

import RPG.BaseCharacteristics.BaseSquirell

class Squirell(
    override var row: Int,
    override var col: Int,
    override var animalCount: Int
) : BaseSquirell(), ICreature {
    override val food: Set<Pair<EFood, ETreePart>> = setOf(TODO("Add food"))
}