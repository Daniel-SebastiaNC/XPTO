package br.com.XPTO.core.domains;

import br.com.XPTO.core.enums.CreditDebitIndicator;

import java.time.LocalDate;

public class BankMovement {
    private Long id;
    private Double value;
    private LocalDate createdAt;
    private CreditDebitIndicator creditDebitIndicator;
    private Account account;

    public BankMovement() {
    }

    public BankMovement(Long id, Double value, LocalDate createdAt, CreditDebitIndicator creditDebitIndicator, Account account) {
        this.id = id;
        this.value = value;
        this.createdAt = createdAt;
        this.creditDebitIndicator = creditDebitIndicator;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public CreditDebitIndicator getCreditDebitIndicator() {
        return creditDebitIndicator;
    }

    public void setCreditDebitIndicator(CreditDebitIndicator creditDebitIndicator) {
        this.creditDebitIndicator = creditDebitIndicator;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
