package Forest.Enums

import kotlin.random.Random

enum class ETree {
    FIR,
    PINE,
    OAK,
    MAPLE,
    BIRCH,
    WALNUT;

    val prettyName = getPrettyName()
}