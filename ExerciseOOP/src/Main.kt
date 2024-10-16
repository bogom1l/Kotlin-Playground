fun main() {

    val duck = Duck(age = 2, gender = "female", beakColor = "Yellow")
    println("Duck: age = ${duck.age}, gender = ${duck.gender}, beakColor = ${duck.beakColor}")
    duck.swim()
    duck.quack()
    println("Is Duck a mammal? : ${duck.isMammal()}")
    duck.mate()

    val fish = Fish(age = 1, gender = "male", sizeInFt = 3, canEat = true)
    println("Fish: age = ${fish.age}, gender = ${fish.gender}, size = ${fish.sizeInFt} ft, canEat = ${fish.canEat}")
    fish.swim()
    println("Is Fish a mammal? : ${fish.isMammal()}")
    fish.mate()

    val zebra = Zebra(age = 4, gender = "female", is_wild = true)
    println("Zebra: age = ${zebra.age}, gender = ${zebra.gender}, isWild = ${zebra.is_wild}")
    zebra.run()
    println("Is Zebra a mammal? : ${zebra.isMammal()}")
    zebra.mate()

    println("-------------------------------------------------")
}








