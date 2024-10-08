fun main() {
    val n: Int = 5

    println(updateNumber(n, ::incrementNumber))
    println(updateNumber(n, ::decrementNumber))
}

fun updateNumber(number: Int, operation: (Int) -> Int): Int {
    return operation(number)
}

fun incrementNumber(number: Int) = number + 1

fun decrementNumber(number: Int): Int {
    return number - 1
}
