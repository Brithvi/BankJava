public class BankAccountManager {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SA12345", 1000.0, 5.0);
        BankAccount checking = new CheckingAccount("CA12345", 500.0, 200.0);

        // Polymorphism: Treating different objects in the same way
        savings.deposit(200);
        savings.withdraw(500);

        checking.deposit(100);
        checking.withdraw(900);

        // Downcasting to access subclass-specific methods
        if (savings instanceof SavingsAccount) {
            ((SavingsAccount) savings).addInterest();
        }

        System.out.println("Savings Account Balance: " + savings.getBalance());
        System.out.println("Checking Account Balance: " + checking.getBalance());
    }
}
