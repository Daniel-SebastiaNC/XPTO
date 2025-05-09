package br.com.XPTO.infra.mappers.account;

import br.com.XPTO.core.domains.Account;
import br.com.XPTO.core.domains.BankMovement;
import br.com.XPTO.infra.exceptions.DataNotFoundException;
import br.com.XPTO.infra.mappers.bankMovements.BankMovementEntityMapper;
import br.com.XPTO.infra.persistence.entities.AccountEntity;
import br.com.XPTO.infra.persistence.entities.BankMovementEntity;
import br.com.XPTO.infra.persistence.entities.ClientEntity;
import br.com.XPTO.infra.persistence.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountEntityMapper {

    private final BankMovementEntityMapper bankMovementEntityMapper;
    private final ClientRepository clientRepository;

    public Account toDomain(AccountEntity accountEntity) {
        List<BankMovement> bankmovements = new ArrayList<>();
        if (!accountEntity.getBankMovements().isEmpty()) {
            bankmovements = accountEntity.getBankMovements().stream().map(bankMovementEntityMapper::toDomain).collect(Collectors.toList());
        }

        return new Account(
                accountEntity.getId(),
                accountEntity.getBalance(),
                bankmovements,
                (accountEntity.getClient() == null) ? 0 : accountEntity.getClient().getId()
        );
    }

    public AccountEntity toEntity(Account domain) {
        ClientEntity clientEntity = null;
        if (domain.getClient() != null && domain.getClient() != 0) {
            clientEntity = clientRepository.findById(domain.getClient())
                    .orElseThrow(() -> new DataNotFoundException("Client Not Found by Id, please contact support"));
        }

        List<BankMovementEntity> bankMovements = new ArrayList<>();
        if (domain.getBankMovements() != null) {
            bankMovements = domain.getBankMovements().stream()
                    .map(bankMovementEntityMapper::toEntity)
                    .collect(Collectors.toList());
        }

        return new AccountEntity(
                domain.getId(),
                (domain.getBalance() == null) ? 0 : domain.getBalance(),
                bankMovements,
                clientEntity
        );
    }
}
