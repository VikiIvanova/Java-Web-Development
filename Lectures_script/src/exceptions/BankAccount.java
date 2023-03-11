package exceptions;

import javax.naming.InsufficientResourcesException;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if(amount > balance) {
            throw new InsufficientFundsException("Insufficient funds in account.");
        }
        balance -= amount;
    }
}
