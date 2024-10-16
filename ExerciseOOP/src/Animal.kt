open class Animal(val age: Int, val gender: String) {

    open fun isMammal(): Boolean {
        return false
    }

    open fun mate() {}

}

class Duck(age: Int, gender: String, val beakColor: String = "Yellow") : Animal(age, gender) {

    override fun isMammal(): Boolean {
        return false
    }

    fun swim() {
        println("Duck is swimming")
    }

    fun quack() {
        println("Duck is quacking")
    }
}

class Fish(age: Int, gender: String, val sizeInFt: Int, val canEat: Boolean) : Animal(age, gender) {
    override fun isMammal(): Boolean {
        return false
    }

    fun swim() {
        println("Fish is swimming")
    }
}

class Zebra(age: Int, gender: String, val is_wild: Boolean) : Animal(age, gender) {
    override fun isMammal(): Boolean {
        return true
    }

    fun run() {
        println("Zebra is running")
    }
}