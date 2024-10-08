fun main() {

    println(updateDirty(15, ::increaseDirty))

}

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun increaseDirty( start: Int ) = start + 1

