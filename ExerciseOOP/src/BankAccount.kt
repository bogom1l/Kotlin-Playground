/*
typealias Dollars = Double
typealias Percentage = Double

open class BankAccount(val owner: String, var balance: Dollars) {

    open fun deposit(amount: Dollars) {
        if (amount > 0) {
            balance += amount
            println("$amount deposited. New balance: $balance")
        } else {
            println("Deposit amount must be positive.")
        }
    }

    open fun withdraw(amount: Dollars) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("$amount withdrawn. New balance: $balance")
        } else {
            println("Insufficient funds for withdrawal.")
        }
    }
}

class CheckingAccount(owner: String, balance: Dollars, val insufficientFundsFee: Dollars) : BankAccount(owner, balance) {

    fun processCheck(checkToProcess: Check) {
        println("Processing check for amount: ${checkToProcess.amount}")
    }

    override fun withdraw(amount: Dollars) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("$amount withdrawn from Checking Account. New balance: $balance")
        } else {
            println("Insufficient funds for withdrawal. Fee of $insufficientFundsFee will be charged.")
            balance -= insufficientFundsFee // Charge the fee
            println("Fee charged. New balance: $balance")
        }
    }
}

class SavingsAccount(owner: String, balance: Dollars, val annualInterestRate: Percentage) : BankAccount(owner, balance) {

    fun depositMonthlyInterest() {
        val monthlyInterest = (balance * (annualInterestRate / 100)) / 12
        deposit(monthlyInterest)
        println("Monthly interest of $monthlyInterest added. New balance: $balance")
    }

    override fun withdraw(amount: Dollars) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("$amount withdrawn from Savings Account. New balance: $balance")
        } else {
            println("Insufficient funds for withdrawal.")
        }
    }
}

data class Check(val amount: Dollars)

*/