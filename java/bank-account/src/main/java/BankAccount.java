import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private final AtomicBoolean isOpen = new AtomicBoolean(false);
    private final AtomicInteger balance = new AtomicInteger(0);

    public void open() {
        isOpen.set(true);
    }

    public int getBalance() throws BankAccountActionInvalidException {
        validateAccountIsOpen();

        return balance.get();
    }

    public void deposit(final int amount) throws BankAccountActionInvalidException {
        validateAccountIsOpen();
        validateAmountIsPositive(amount);

        balance.getAndAdd(amount);
    }

    public void withdraw(final int amount) throws BankAccountActionInvalidException {
        validateAccountIsOpen();
        validateBalanceIsNonZero();
        validateAmountIsPositive(amount);
        validateBalanceIsSufficient(amount);

        balance.getAndAdd(-amount);
    }

    public void close() {
        isOpen.set(false);
    }

    private void validateAccountIsOpen() throws BankAccountActionInvalidException {
        if (!isOpen.get()) {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    private static void validateAmountIsPositive(final int amount) throws BankAccountActionInvalidException {
        if (amount < 0) {
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
    }

    private void validateBalanceIsNonZero() throws BankAccountActionInvalidException {
        if (balance.get() == 0) {
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }
    }

    private void validateBalanceIsSufficient(final int amount) throws BankAccountActionInvalidException {
        if (amount > balance.get()) {
            throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }
    }
}