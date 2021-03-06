package ejercicios.clase3.ex4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    @Test
    @DisplayName("showBalance | initially | ok")
    void showBalanceInitially () {
        final Wallet wallet = new Wallet(1L, "ARG", ClientType.PERSON, WalletType.REGULAR);

        assertEquals(0d, wallet.showBalance());
    }

    @Test
    @DisplayName("deposit | ok")
    void deposit () {
        final Wallet wallet = new Wallet(1L, "ARG", ClientType.PERSON, WalletType.REGULAR);

        wallet.deposit(100d);

        assertEquals(70, wallet.showBalance());
    }

    @Test
    @DisplayName("extract | ok")
    void extract () throws Wallet.WalletException {
        final Wallet wallet = new Wallet(1L, "ARG", ClientType.PERSON, WalletType.REGULAR);

        wallet.deposit(100d);
        wallet.extract(30d);

        assertEquals(40, wallet.showBalance());
    }

    @Test
    @DisplayName("extract | insufficient | should throw WalletException")
    void extractInsufficient () {
        final Wallet wallet = new Wallet(1L, "ARG", ClientType.PERSON, WalletType.REGULAR);

        final Wallet.WalletException exception = assertThrows(Wallet.WalletException.class, () -> wallet.extract(1d));

        assertEquals("fondos insuficientes", exception.getMessage());
    }
}