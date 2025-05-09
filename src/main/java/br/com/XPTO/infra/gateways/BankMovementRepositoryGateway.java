package br.com.XPTO.infra.gateways;

import br.com.XPTO.core.domains.BankMovement;
import br.com.XPTO.core.gateways.BankMovementGateway;
import br.com.XPTO.infra.mappers.bankMovements.BankMovementEntityMapper;
import br.com.XPTO.infra.persistence.repositories.BankMovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankMovementRepositoryGateway implements BankMovementGateway {

    private final BankMovementRepository repository;
    private final BankMovementEntityMapper mapper;

    @Override
    public BankMovement saveBankMovement(BankMovement bankMovement) {
        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(bankMovement)
                )
        );
    }
}
