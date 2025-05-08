package br.com.XPTO.infra.gateways;

import br.com.XPTO.core.domains.Account;
import br.com.XPTO.core.gateways.AccountGateway;
import br.com.XPTO.infra.mappers.account.AccountEntityMapper;
import br.com.XPTO.infra.persistence.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountRepositoryGateway implements AccountGateway {

    private final AccountRepository repository;
    private final AccountEntityMapper mapper;

    @Override
    public Account saveAccount(Account account) {
        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(account)
                )
        );
    }
}
