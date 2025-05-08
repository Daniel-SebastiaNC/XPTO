package br.com.XPTO.core.domains;
import java.util.List;

public class Account {
    private Long id;
    private Double balance;
    List<BankMovement> bankMovements;
    private Client client;

    public Account() {
    }

    public Account(Long id, Double balance, List<BankMovement> bankMovements, Client client) {
        this.id = id;
        this.balance = balance;
        this.bankMovements = bankMovements;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<BankMovement> getBankMovements() {
        return bankMovements;
    }

    public void setBankMovements(List<BankMovement> bankMovements) {
        this.bankMovements = bankMovements;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
