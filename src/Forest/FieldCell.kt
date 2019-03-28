package Forest

import Forest.Enums.EFood
import Forest.Enums.ETree
import Forest.Enums.ETreePart
import kotlin.random.Random

class FieldCell(private val tree: ETree) {
    private val food: MutableMap<EFood, Int> = mutableMapOf()

    init {
        val possibleFood: List<EFood> = when (tree) {
            ETree.FIR, ETree.PINE, ETree.WALNUT -> listOf(EFood.NUTS, EFood.CONES)
            ETree.MAPLE -> listOf(EFood.MAPLE_LEAVES)
            else -> listOf()
        } + listOf(EFood.WORMS, EFood.ROOT_VEGETABLES)

        possibleFood.map { food.put(it, 0) }
    }

    fun update(foodProbability: Float) {
        food.map { if (Random.nextFloat() < foodProbability) food[it.key] = it.value + Random.nextInt(1, 5) }
    }

    fun hasFood() : Boolean = food.any { it.value > 0 }

    fun getFood() : MutableMap<EFood, Int> = food

    fun setFood(newFoodUnits: List<Pair<EFood, Int>>) {
        food.putAll(newFoodUnits.toMap())
    }
}