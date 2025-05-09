package br.com.XPTO.infra.beans;

import br.com.XPTO.core.gateways.AccountGateway;
import br.com.XPTO.core.gateways.BankMovementGateway;
import br.com.XPTO.core.gateways.ClientGateway;
import br.com.XPTO.core.usecases.account.CreateBankAccountUsecase;
import br.com.XPTO.core.usecases.account.CreateBankAccountUsecaseImpl;
import br.com.XPTO.core.usecases.account.MakeBankMovementUsecase;
import br.com.XPTO.core.usecases.account.MakeBankMovementUsecaseImpl;
import br.com.XPTO.core.usecases.client.CreateClientUsacase;
import br.com.XPTO.core.usecases.client.CreateClientUsacaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CreateBankAccountUsecase createBankAccountUsecase(AccountGateway accountGateway) {
        return new CreateBankAccountUsecaseImpl(accountGateway);
    }

    @Bean
    public MakeBankMovementUsecase makeBankMovementUsecase(AccountGateway accountGateway, BankMovementGateway bankMovementGateway) {
        return new MakeBankMovementUsecaseImpl(accountGateway, bankMovementGateway);
    }

    @Bean
    public CreateClientUsacase createClientUsacase(ClientGateway clientGateway, AccountGateway accountGateway) {
        return new CreateClientUsacaseImpl(clientGateway, accountGateway);
    }
}
