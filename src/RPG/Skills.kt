package RPG

class Skill(private var currentExpirience: Int = 0) {
    fun getMultiplier(): Int = multipliersOnLevel[expToLevelUp.indexOfLast { it <= currentExpirience }]

    fun addExp(exp: Int) {
        currentExpirience += exp
    }

    companion object Levels {
        val expToLevelUp = listOf(0, 100, 250, 500, 1000, 2500)
        val multipliersOnLevel = listOf(0, 1, 2, 5, 10, 20)
    }
}

class BaseSkills {
    val strength = Skill()
    val agility = Skill()
    val endurance = Skill()
    val diplomacy = Skill()
    val pathfinding = Skill()
}

interface ISkills {
    val skills: BaseSkills

    fun getStrength() = skills.strength.getMultiplier()
    fun addExpToStrength(exp: Int) = skills.strength.addExp(exp)

    fun getAgility() = skills.agility.getMultiplier()
    fun addExpToAgility(exp: Int) = skills.agility.addExp(exp)

    fun getEndurance() = skills.endurance.getMultiplier()
    fun addExpToEndurance(exp: Int) = skills.endurance.addExp(exp)

    fun getDiplomacy() = skills.diplomacy.getMultiplier()
    fun addExpToDiplomacy(exp: Int) = skills.diplomacy.addExp(exp)

    fun getPathfinding() = skills.pathfinding.getMultiplier()
    fun addExpToPathfinding(exp: Int) = skills.pathfinding.addExp(exp)
}