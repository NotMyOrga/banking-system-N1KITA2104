package bank;

import java.util.*;
import main.Person;

public class Bank {
    private final Map<Person, BankAccount> bankAccounts = new HashMap<>();

    public void registerCustomer(Person person, double initialDeposit) {
        bankAccounts.put(person, new BankAccount(person, initialDeposit));
    }

  public boolean transfer(Person from, Person to, double amount) {
    BankAccount fromAccount = bankAccounts.get(from);
    BankAccount toAccount = bankAccounts.get(to);

    if (fromAccount == null || toAccount == null) return false;
    if (!fromAccount.withdraw(amount)) return false;

    toAccount.deposit(amount);
    return true;
  }

  public double getBalance(Person customer) {
        if (bankAccounts.containsKey(customer)) {
            return bankAccounts.get(customer).getBalance();
        }
        return 0.0;
    }
}

