package ejercicios.clase3.ex4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private final Wallet.Builder builder = new Wallet.Builder()
            .setClientType(ClientType.PERSON)
            .setCountry("ARG")
            .setWalletType(WalletType.REGULAR);

    @Test
    void deposit() {
        final long cbu = 1L;

        final Wallet wallet = builder.setCbu(cbu).build();

        final Bank bank = new Bank();
        bank.addWallet(wallet);

        bank.deposit(cbu, 100d);

        assertEquals(70d, bank.showBalance(cbu));
    }

    @Test
    void extract() {
        final long cbu = 1L;

        final Wallet wallet = builder.setCbu(cbu).build();

        final Bank bank = new Bank();
        bank.addWallet(wallet);

        bank.deposit(cbu, 100d);
        bank.extract(cbu, 30d);

        assertEquals(40d, bank.showBalance(cbu));
    }

    @Test
    void extractInsufficientFounds() {
        final long cbu = 1L;

        final Wallet wallet = builder.setCbu(cbu).build();

        final Bank bank = new Bank();
        bank.addWallet(wallet);

        final Bank.BankException exception = assertThrows(Bank.BankException.class, () -> bank.extract(cbu, 1d));

        assertEquals("Querido usuario: fondos insuficientes", exception.getMessage());
    }

    @Test
    void showBalanceWalletNotFound() {
        final Bank bank = new Bank();

        final Bank.BankException exception = assertThrows(Bank.BankException.class, () -> bank.showBalance(1L));

        assertEquals("Wallet not found", exception.getMessage());
    }

    @Test
    @DisplayName("transfer | ok")
    void transferOk() throws Wallet.WalletException {
        long cbuOrigin = 1L;
        long cbuDestination = 2L;

        final Wallet walletOrigin = builder.setCbu(cbuOrigin).build();
        final Wallet walletDestination = builder.setCbu(cbuDestination).build();

        final Bank bank = new Bank();

        bank.addWallet(walletOrigin);
        bank.addWallet(walletDestination);

        bank.deposit(cbuOrigin, 100d);

        bank.transfer(cbuOrigin, cbuDestination, 30d);

        assertAll("Expected result",
                () -> assertEquals(40d, bank.showBalance(cbuOrigin)),
                () -> assertEquals(21d, bank.showBalance(cbuDestination))
                );
    }

    @Test
    @DisplayName("transfer | insufficient founds | should throws BankException")
    void transferInsufficientFounds() throws Wallet.WalletException {
        long cbuOrigin = 1L;
        long cbuDestination = 2L;

        final Wallet walletOrigin = builder.setCbu(cbuOrigin).build();
        final Wallet walletDestination = builder.setCbu(cbuDestination).build();

        final Bank bank = new Bank();

        bank.addWallet(walletOrigin);
        bank.addWallet(walletDestination);

        final Bank.BankException exception =
                assertThrows(Bank.BankException.class, () -> bank.transfer(cbuOrigin, cbuDestination, 30d));

        assertEquals("Querido usuario: fondos insuficientes", exception.getMessage());
    }
}