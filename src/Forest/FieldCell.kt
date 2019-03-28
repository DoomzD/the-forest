package Forest

import Forest.Enums.EFood
import Forest.Enums.ETree
import Forest.Enums.ETreePart
import kotlin.random.Random

class FieldCell(private val tree: ETree) {
    private val food: MutableMap<Pair<EFood, ETreePart>, Int> = mutableMapOf()

    init {
        val possibleFood: List<Pair<EFood, ETreePart>> = when (tree) {
            ETree.FIR, ETree.PINE, ETree.WALNUT -> listOf(
                Pair(EFood.NUTS, ETreePart.CROWN),
                Pair(EFood.CONES, ETreePart.CROWN)
            )
            ETree.MAPLE -> listOf(Pair(EFood.MAPLE_LEAVES, ETreePart.CROWN))
            else -> listOf()
        } + listOf(Pair(EFood.WORMS, ETreePart.TRUNK), Pair(EFood.ROOT_VEGETABLES, ETreePart.ROOTS))

        possibleFood.map { food.put(it, 0) }
    }

    fun update(foodProbability: Float) {
        food.map { if (Random.nextFloat() < foodProbability) food[it.key] = it.value + Random.nextInt(1, 5) }
    }

    fun hasFood() : Boolean = food.any { it.value > 0 }

    fun getFood() : MutableMap<Pair<EFood, ETreePart>, Int> = food
}