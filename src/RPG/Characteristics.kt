package RPG

interface ICharacteristics {
    var health: Int
    val additionalHealthOnLevelUp: Int

    var damage: IntRange
    val additionalDamageOnLevelUp: IntRange

    var maxWeight: Int
    val additionalWeightOnLevelUp: Int

    var intellect: Int
    val additionalIntellectOnLevelUp: Int

    var stamina: Int
    var hunger: Int
}
