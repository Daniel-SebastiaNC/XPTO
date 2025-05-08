package br.com.XPTO.infra.beans;

import br.com.XPTO.core.gateways.AccountGateway;
import br.com.XPTO.core.usecases.account.CreateBankAccountUsecase;
import br.com.XPTO.core.usecases.account.CreateBankAccountUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CreateBankAccountUsecase createBankAccountUsecase(AccountGateway accountGateway) {
        return new CreateBankAccountUsecaseImpl(accountGateway);
    }
}
