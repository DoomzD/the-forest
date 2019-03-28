package Forest.Animals

import Forest.AnimalInterfaces.FlyingCreature
import RPG.BaseCharacteristics.BaseFlyingSquirell

class FlyingSquirell : BaseFlyingSquirell(), FlyingCreature {
    override val row = 0
    override val col = 0
}