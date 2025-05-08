package br.com.XPTO.core.domains;

import br.com.XPTO.core.enums.TaxIdentifiers;


import java.time.LocalDate;
import java.util.List;

public class Client {
    private Long id;
    private String name;
    private String cpfCnpj;
    private Address address;
    private List<Account> accounts;
    private TaxIdentifiers taxIdentifiers;
    private String telephone;
    private LocalDate createdAt;
    private Double balanceTotal;
    
    public Client() {
    }

    public Client(String name, String cpfCnpj, Address address, List<Account> accounts, TaxIdentifiers taxIdentifiers, String telephone, LocalDate createdAt, Double balanceTotal) {
        this.name = name;
        this.cpfCnpj = cpfCnpj;
        this.address = address;
        this.accounts = accounts;
        this.taxIdentifiers = taxIdentifiers;
        this.telephone = telephone;
        this.createdAt = createdAt;
        this.balanceTotal = balanceTotal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public TaxIdentifiers getTaxIdentifiers() {
        return taxIdentifiers;
    }

    public void setTaxIdentifiers(TaxIdentifiers taxIdentifiers) {
        this.taxIdentifiers = taxIdentifiers;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Double getBalanceTotal() {
        return balanceTotal;
    }

    public void setBalanceTotal(Double balanceTotal) {
        this.balanceTotal = balanceTotal;
    }
}
