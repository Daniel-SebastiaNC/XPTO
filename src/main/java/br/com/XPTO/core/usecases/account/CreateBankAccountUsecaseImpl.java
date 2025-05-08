package br.com.XPTO.core.usecases.account;

import br.com.XPTO.core.domains.Account;
import br.com.XPTO.core.gateways.AccountGateway;

public class CreateBankAccountUsecaseImpl implements CreateBankAccountUsecase {

    private final AccountGateway gateway;

    public CreateBankAccountUsecaseImpl(AccountGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Account execute() {
        return gateway.saveAccount(new Account());
    }
}
