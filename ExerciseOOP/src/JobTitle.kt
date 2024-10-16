/*
typealias Dollars = Double

// Enum for Job Titles
enum class JobTitle {
    PROFESSOR,
    LECTURER,
    ASSISTANT_PROFESSOR
}

// Interface for Person
interface Person {
    val firstName: String
    val lastName: String
}

// Abstract Class for Employee, implementing Person
abstract class Employee(override val firstName: String, override val lastName: String, val salary: Dollars, val jobTitle: JobTitle) : Person {
    abstract fun work(): String // Abstract method to describe what the employee does
}

// Class for Professor, inheriting from Employee
class Professor(firstName: String, lastName: String, salary: Dollars) : Employee(firstName, lastName, salary, JobTitle.PROFESSOR) {

    override fun work(): String {
        return "$firstName $lastName is teaching and conducting research."
    }
}

// Class for Student, implementing Person
data class Student(override val firstName: String, override val lastName: String, val major: String) : Person {

    fun study() {
        println("$firstName $lastName is studying $major.")
    }
}

*/
