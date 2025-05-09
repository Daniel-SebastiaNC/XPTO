package br.com.XPTO.infra.mappers.client;

import br.com.XPTO.core.domains.Account;
import br.com.XPTO.core.domains.Client;
import br.com.XPTO.infra.mappers.account.AccountEntityMapper;
import br.com.XPTO.infra.mappers.address.AddressEntityMapper;
import br.com.XPTO.infra.persistence.entities.AccountEntity;
import br.com.XPTO.infra.persistence.entities.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClientEntityMapper {

    private final AddressEntityMapper addressEntityMapper;
    private final AccountEntityMapper accountEntityMapper;

    public Client toDomain(ClientEntity entity) {
        List<Account> accounts = new ArrayList<>();
        if (!entity.getAccounts().isEmpty()) {
            accounts = entity.getAccounts().stream().map(accountEntityMapper::toDomain).collect(Collectors.toList());
        }

        return new Client(
                entity.getId(),
                entity.getName(),
                entity.getCpfCnpj(),
                addressEntityMapper.toDomain(entity.getAddress()),
                accounts,
                entity.getTaxIdentifiers(),
                entity.getTelephone(),
                entity.getCreatedAt(),
                entity.getBalanceTotal()
        );
    }

    public ClientEntity toEntity(Client domain) {
        List<AccountEntity> accounts = new ArrayList<>();
        if (!domain.getAccounts().isEmpty()) {
            accounts = domain.getAccounts().stream().map(accountEntityMapper::toEntity).collect(Collectors.toList());
        }

        return new ClientEntity(
                domain.getId(),
                domain.getName(),
                domain.getCpfCnpj(),
                addressEntityMapper.toEntity(domain.getAddress()),
                accounts,
                domain.getTaxIdentifiers(),
                domain.getTelephone(),
                domain.getCreatedAt(),
                domain.getBalanceTotal()
        );
    }
}
