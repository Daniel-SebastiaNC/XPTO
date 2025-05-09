package br.com.XPTO.core.gateways;

import br.com.XPTO.core.domains.Account;
import br.com.XPTO.core.domains.BankMovement;

import java.util.Optional;

public interface AccountGateway {
    Account saveAccount(Account account);
    Optional<Account> findAccountById(Long id);
}
