import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private double fee;

    @BeforeEach
    void beforeEach(){
        fee = 1;
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0, fee);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100 - fee, bankAccount.getBalance());
    }

    @Test
    void testDepositWithWrongUser() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
        assertEquals(100 - fee, bankAccount.getBalance());
    }

    @Test
    void testDepositWithWrongAmount() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(accountHolder.getId(), -20);
        bankAccount.deposit(accountHolder.getId(), fee);
        assertEquals(100 - fee, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30 - 2*fee, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithWrongUser() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(2, 70);
        assertEquals(100 - fee, bankAccount.getBalance());
    }
    @Test
    void testWithdrawWithWrongAmount() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), -20);
        bankAccount.withdraw(accountHolder.getId(), bankAccount.getBalance());
        assertEquals(100 - fee, bankAccount.getBalance());
    }
}
