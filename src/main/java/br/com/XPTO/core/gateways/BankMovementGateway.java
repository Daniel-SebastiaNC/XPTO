package br.com.XPTO.core.gateways;

import br.com.XPTO.core.domains.Account;
import br.com.XPTO.core.domains.BankMovement;

public interface BankMovementGateway {
    BankMovement saveBankMovement(BankMovement bankMovement);
}
