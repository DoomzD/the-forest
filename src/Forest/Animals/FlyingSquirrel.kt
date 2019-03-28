package Forest.Animals

import Forest.AnimalInterfaces.IFlyingCreature
import Forest.Enums.EAnimal
import Forest.Enums.EFood
import RPG.BaseSkills

class FlyingSquirrel(
    override var row: Int,
    override var col: Int,
    override var animalCount: Int
) : IFlyingCreature {
    override val food: Set<EFood> = setOf(EFood.MAPLE_LEAVES)
    override val animalType = EAnimal.FLYING_SQUIRREL

    override var stamina = 50.0f
    override var hungriness = 50.0f

    override val skills = BaseSkills()

    override var health: Int = 1
    override val additionalHealthOnLevelUp: Int = 1

    override var damage: IntRange = 1..1
    override val additionalDamageOnLevelUp: IntRange = 1..1

    override var maxWeight: Int = 1
    override val additionalWeightOnLevelUp: Int = 1

    override var intellect: Int = 1
    override val additionalIntellectOnLevelUp: Int = 1
}