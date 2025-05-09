package br.com.XPTO.core.usecases.account;

import br.com.XPTO.core.domains.BankMovement;

public interface MakeBankMovementUsecase {
    BankMovement execute(Long id, BankMovement bankMovement);
}
