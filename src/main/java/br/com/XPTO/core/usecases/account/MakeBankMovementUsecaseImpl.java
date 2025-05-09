package br.com.XPTO.core.usecases.account;

import br.com.XPTO.core.domains.Account;
import br.com.XPTO.core.domains.BankMovement;
import br.com.XPTO.core.enums.CreditDebitIndicator;
import br.com.XPTO.core.gateways.AccountGateway;
import br.com.XPTO.core.gateways.BankMovementGateway;
import br.com.XPTO.infra.exceptions.DataNotFoundException;
import br.com.XPTO.infra.exceptions.NotEnoughMoneyAccountException;

import java.time.LocalDate;

public class MakeBankMovementUsecaseImpl implements MakeBankMovementUsecase{

    private final AccountGateway accountGateway;
    private final BankMovementGateway bankMovementGateway;

    public MakeBankMovementUsecaseImpl(AccountGateway accountGateway, BankMovementGateway bankMovementGateway) {
        this.accountGateway = accountGateway;
        this.bankMovementGateway = bankMovementGateway;
    }

    @Override
    public BankMovement execute(Long id, BankMovement bankMovement) {
        // Set data BankMovement
        bankMovement.setAccount(id);
        bankMovement.setCreatedAt(LocalDate.now());

        // Get Account OR ERROR
        Account accountById = accountGateway.findAccountById(id).orElseThrow(() -> new DataNotFoundException("Account Not Found, please insert a valid id"));

        // Verification: Account balance can't be negative
        if (bankMovement.getValue() > accountById.getBalance() && bankMovement.getCreditDebitIndicator().equals(CreditDebitIndicator.DEBIT)) {
            throw new NotEnoughMoneyAccountException("Not enough money in the account");
        }

        // Update balance after to verification
        Double newBalance = accountById.getBalance();
        switch (bankMovement.getCreditDebitIndicator()){
            case CREDIT:
                newBalance += bankMovement.getValue();
                break;
            case DEBIT:
                newBalance -= bankMovement.getValue();
                break;
        }
        accountById.setBalance(newBalance);

        // Update Account by Id and create BankMovement
        accountGateway.saveAccount(accountById);
        return bankMovementGateway.saveBankMovement(bankMovement);
    }
}
