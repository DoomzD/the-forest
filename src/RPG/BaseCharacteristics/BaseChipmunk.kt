package RPG.BaseCharacteristics

import RPG.ICharacteristics
import RPG.ISkills

abstract class BaseChipmunk : ICharacteristics, ISkills {
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