import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount savingsAccount;
    private BankAccount checkingAccount;

    @BeforeEach
    public void setUp() {
        savingsAccount = new SavingsAccount("SA12345", 1000.0, 5.0);
        checkingAccount = new CheckingAccount("CA12345", 500.0, 200.0);
    }

    @Test
    public void testDepositSavingsAccount() {
        savingsAccount.deposit(200);
        assertEquals(1200.0, savingsAccount.getBalance());
    }

    @Test
    public void testWithdrawSavingsAccount() {
        savingsAccount.withdraw(500);
        assertEquals(500.0, savingsAccount.getBalance());
    }

    @Test
    public void testWithdrawSavingsAccountInsufficientFunds() {
        savingsAccount.withdraw(1500);
        assertEquals(1000.0, savingsAccount.getBalance());  // Balance should remain unchanged
    }

    @Test
    public void testAddInterestSavingsAccount() {
        if (savingsAccount instanceof SavingsAccount) {
            ((SavingsAccount) savingsAccount).addInterest();
        }
        assertEquals(1050.0, savingsAccount.getBalance());  // 5% interest on 1000.0
    }

    @Test
    public void testDepositCheckingAccount() {
        checkingAccount.deposit(300);
        assertEquals(800.0, checkingAccount.getBalance());
    }

    @Test
    public void testWithdrawCheckingAccountWithinOverdraftLimit() {
        checkingAccount.withdraw(600);
        assertEquals(-100.0, checkingAccount.getBalance());  // Balance goes negative within overdraft limit
    }

    @Test
    public void testWithdrawCheckingAccountExceedingOverdraftLimit() {
        checkingAccount.withdraw(800);
        assertEquals(500.0, checkingAccount.getBalance());  // Balance should remain unchanged
    }
}
