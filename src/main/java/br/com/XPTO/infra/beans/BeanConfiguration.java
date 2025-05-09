package br.com.XPTO.infra.beans;

import br.com.XPTO.core.gateways.AccountGateway;
import br.com.XPTO.core.gateways.AddressGateway;
import br.com.XPTO.core.gateways.BankMovementGateway;
import br.com.XPTO.core.gateways.ClientGateway;
import br.com.XPTO.core.usecases.account.CreateBankAccountUsecase;
import br.com.XPTO.core.usecases.account.CreateBankAccountUsecaseImpl;
import br.com.XPTO.core.usecases.account.MakeBankMovementUsecase;
import br.com.XPTO.core.usecases.account.MakeBankMovementUsecaseImpl;
import br.com.XPTO.core.usecases.address.UpdateAddressUsecase;
import br.com.XPTO.core.usecases.address.UpdateAddressUsecaseImpl;
import br.com.XPTO.core.usecases.client.CreateClientUsacase;
import br.com.XPTO.core.usecases.client.CreateClientUsacaseImpl;
import br.com.XPTO.core.usecases.client.ReportByClientUsecase;
import br.com.XPTO.core.usecases.client.ReportByClientUsecaseImpl;
import br.com.XPTO.infra.mappers.address.AddressDtoMapper;
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

    @Bean
    public UpdateAddressUsecase updateAddressUsecase(ClientGateway clientGateway, AddressGateway addressGateway){
        return new UpdateAddressUsecaseImpl(clientGateway, addressGateway);
    }

    @Bean
    public ReportByClientUsecase reportByClientUsecase(ClientGateway clientGateway, AddressDtoMapper addressDtoMapper){
        return new ReportByClientUsecaseImpl(clientGateway, addressDtoMapper);
    }
}
