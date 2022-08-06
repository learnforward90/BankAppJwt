package kz.alibek.bankapp.bank.transaction;

public enum TransactionType {
    DEPOSIT("DEPOSIT"),
    WITHDRAW("WITHDRAW");

    private String name;

    TransactionType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
