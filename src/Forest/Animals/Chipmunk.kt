package Forest.Animals

import Forest.AnimalInterfaces.ICreature
import Forest.Enums.ETreePart
import Forest.Enums.EFood

import RPG.BaseCharacteristics.BaseChipmunk

class Chipmunk(
    override var row: Int,
    override var col: Int,
    override var animalCount: Int
) : BaseChipmunk(), ICreature {
    override val food: Set<Pair<EFood, ETreePart>> = setOf(TODO("Add food"))
}