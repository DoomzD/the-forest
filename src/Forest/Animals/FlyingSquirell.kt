package Forest.Animals

import Forest.AnimalInterfaces.IFlyingCreature
import Forest.Enums.EFood
import Forest.Enums.ETreePart

import RPG.BaseCharacteristics.BaseFlyingSquirell

class FlyingSquirell(
    override var row: Int,
    override var col: Int,
    override var animalCount: Int
) : BaseFlyingSquirell(), IFlyingCreature {
    override val food: Set<Pair<EFood, ETreePart>> = setOf(TODO("Add food"))
}