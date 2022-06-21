package ejercicios.clase3.ex4;

import ejercicios.clase3.ex1.Calculator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private static final int TAX_PERCENTAGE = 30;

    private long cbu;
    private String country;
    private ClientType clientType;
    private WalletType walletType;
    private LocalDateTime dateCreated;
    private List<WalletTransaction> transactions;

    public Wallet (long cbu,
                  String country,
                  ClientType cLientType,
                  WalletType walletType) {

        this.cbu = cbu;
        this.country = country;
        this.clientType = cLientType;
        this.walletType = walletType;

        this.dateCreated = LocalDateTime.now();
        this.transactions = new ArrayList<>();
    }

    public double showBalance () {
        double totalDeposited = 0;
        double totalExtracted = 0;

        for (WalletTransaction transaction : transactions) {
            final double amount = transaction.getAmount();
            final WalletOperation operation = transaction.getOperation();

            if (operation == WalletOperation.DEPOSIT) {
                totalDeposited += amount;
            } else if (operation == WalletOperation.EXTRACTION) {
                totalExtracted += amount;
            }

        }

        return totalDeposited - totalExtracted;
    }

    public void deposit (double amount) {
        final Calculator taxCalculator = new Calculator(amount, TAX_PERCENTAGE );
        final double taxReduction = taxCalculator.percentage();

        final Calculator reductionCalculator = new Calculator(amount, taxReduction);

        final double depositAmount = reductionCalculator.subtract();

        this.transactions.add(new WalletTransaction(WalletOperation.DEPOSIT, depositAmount));
    }

    public void extract (double amount) throws WalletException {
        if (amount > this.showBalance()) {
            throw new WalletException("fondos insuficientes");
        }

        this.transactions.add(new WalletTransaction(WalletOperation.EXTRACTION, amount));
    }

    public long getCbu() {
        return cbu;
    }

    public static final class WalletException extends Exception {   // excepción privada de la clase
        private WalletException(String message) {
            super(message);
        }
    }

    public static class Builder {
        private long cbu;
        private String country;
        private ClientType clientType;
        private WalletType walletType;

        public Wallet build() {
            return new Wallet(cbu, country, clientType, walletType);
        }

        public Builder setCbu(long cbu) {
            this.cbu = cbu;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setClientType(ClientType clientType) {
            this.clientType = clientType;
            return this;
        }

        public Builder setWalletType(WalletType walletType) {
            this.walletType = walletType;
            return this;
        }
    }
}



