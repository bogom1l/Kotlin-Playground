fun main() {
    val n: Int = 5
    val q = 2

    println(updateNumber(q, ::incrementNumber))
    println(updateNumber(q, ::decrementNumber))
}

fun updateNumber(number: Int, operation: (Int) -> Int): Int {
    return operation(number)
}

fun incrementNumber(number: Int) = number + 1

fun decrementNumber(number: Int): Int {
    return number - 1
}
