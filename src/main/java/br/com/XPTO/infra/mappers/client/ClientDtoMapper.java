package br.com.XPTO.infra.mappers.client;

import br.com.XPTO.core.domains.Account;
import br.com.XPTO.core.domains.Client;
import br.com.XPTO.core.enums.TaxIdentifiers;
import br.com.XPTO.core.gateways.AccountGateway;
import br.com.XPTO.infra.dtos.account.responses.AccountResponse;
import br.com.XPTO.infra.dtos.client.requests.ClientRequest;
import br.com.XPTO.infra.dtos.client.responses.ClientResponse;
import br.com.XPTO.infra.exceptions.DataNotFoundException;
import br.com.XPTO.infra.mappers.account.AccountDtoMapper;
import br.com.XPTO.infra.mappers.address.AddressDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClientDtoMapper {

    private final AddressDtoMapper addressDtoMapper;
    private final AccountDtoMapper accountDtoMapper;

    private final AccountGateway accountGateway;

    public Client toDomain(ClientRequest request) {
        List<Account> accounts = new ArrayList<>();

        if (request.getAccounts() != null && !request.getAccounts().isEmpty()) {
            for (Long account : request.getAccounts()) {
                accounts.add(
                        accountGateway.findAccountById(account)
                                .orElseThrow(() -> new DataNotFoundException("Account with " + account + " Not Found"))
                );
            }
        }


        return new Client(
                null,
                request.getName(),
                request.getCpfCnpj(),
                addressDtoMapper.toDomain(request.getAddress()),
                accounts,
                TaxIdentifiers.valueOf(request.getTaxIdentifiers()),
                request.getTelephone(),
                null,
                null
        );
    }

    public ClientResponse toDto(Client client) {
        List<AccountResponse> accounts = new ArrayList<>();
        if (!client.getAccounts().isEmpty()) {
            accounts = client.getAccounts().stream().map(accountDtoMapper::toDto).collect(Collectors.toList());
        }

        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getCpfCnpj(),
                addressDtoMapper.toDto(client.getAddress()),
                accounts,
                client.getTaxIdentifiers(),
                client.getTelephone(),
                client.getCreatedAt(),
                client.getBalanceTotal()
        );
    }
}
