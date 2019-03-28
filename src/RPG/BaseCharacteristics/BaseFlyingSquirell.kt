package RPG.BaseCharacteristics

import RPG.BaseSkills
import RPG.IAnimalCharacteristics
import RPG.ISkills

abstract class BaseFlyingSquirell : IAnimalCharacteristics, ISkills {
    override val skills = BaseSkills()

    override var health: Int = 1
    override val additionalHealthOnLevelUp: Int = 1

    override var damage: IntRange = 1..1
    override val additionalDamageOnLevelUp: IntRange = 1..1

    override var maxWeight: Int = 1
    override val additionalWeightOnLevelUp: Int = 1

    override var intellect: Int = 1
    override val additionalIntellectOnLevelUp: Int = 1

    override var stamina: Int = 1
    override var hunger: Int = 1
}