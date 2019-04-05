package Forest.AnimalInterfaces

import Forest.FieldCell
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

interface IFlyingCreature : ICreature {
    fun makeMove(field: List<List<FieldCell>>) = super.makeMove(field, 2, 0f)
}