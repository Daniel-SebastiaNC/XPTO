package br.com.XPTO.infra.mappers.bankMovements;

import br.com.XPTO.core.domains.BankMovement;
import br.com.XPTO.infra.persistence.entities.AccountEntity;
import br.com.XPTO.infra.persistence.entities.BankMovementEntity;
import br.com.XPTO.infra.persistence.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankMovementEntityMapper {

    private final AccountRepository accountRepository;

    public BankMovement toDomain(BankMovementEntity entity) {
        return new BankMovement(
                entity.getId(),
                entity.getValue(),
                entity.getCreatedAt(),
                entity.getCreditDebitIndicator(),
                entity.getAccount().getId()
        );
    }

    public BankMovementEntity toEntity(BankMovement domain) {
        AccountEntity byId = accountRepository.findById(domain.getAccount()).orElseThrow(() -> new RuntimeException());

        return new BankMovementEntity(
                domain.getId(),
                domain.getValue(),
                domain.getCreatedAt(),
                domain.getCreditDebitIndicator(),
                byId
        );
    }
}
