fun main() {
    /*
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

       val zebra = Zebra(age = 4, gender = "female", is_wild = true)
       println("Zebra: age = ${zebra.age}, gender = ${zebra.gender}, isWild = ${zebra.is_wild}")
       zebra.run()
       println("Is Zebra a mammal? : ${zebra.isMammal()}")

       println("-------------------------------------------------")

       val checkingAccount = CheckingAccount("Alice", 1000.0, 35.0)
       checkingAccount.deposit(200.0)
       checkingAccount.withdraw(150.0)
       checkingAccount.withdraw(1200.0) // This should incur the insufficient funds fee
       checkingAccount.processCheck(Check(300.0))

       val savingsAccount = SavingsAccount("Bob", 1500.0, 5.0)
       savingsAccount.deposit(500.0)
       savingsAccount.depositMonthlyInterest() // This should calculate and add monthly interest
       savingsAccount.withdraw(200.0)

       println("-------------------------------------------------")

       val professor = Professor(firstName = "Alice", lastName = "Smith", salary = 75000.0)
       println(professor)
       professor.teach()

       // Create a Student instance
       val student = Student(major = "CS", firstName = "Johnson", lastName = "Computer Science")
       println("Student: ${student.firstName} ${student.lastName}, Major: ${student.major}")
       student.study()
       */

    // Create a Professor instance
    val professor = Professor("Alice", "Smith", 75000.0)
    println("Professor: ${professor.firstName} ${professor.lastName}, Salary: ${professor.salary}, Job Title: ${professor.jobTitle}")
    println(professor.work()) // Call the work method

    // Create a Student instance
    val student = Student("Bob", "Johnson", "Computer Science")
    println(student)
    student.study() // Call the study method

    // Example of another employee
    val lecturer = object : Employee("Charlie", "Brown", 60000.0, JobTitle.LECTURER) {
        override fun work(): String {
            return "$firstName $lastName is giving lectures."
        }
    }

    println("Lecturer: ${lecturer.firstName} ${lecturer.lastName}, Salary: ${lecturer.salary}, Job Title: ${lecturer.jobTitle}")
    println(lecturer.work())


}








