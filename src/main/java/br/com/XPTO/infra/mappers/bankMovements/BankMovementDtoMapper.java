package br.com.XPTO.infra.mappers.bankMovements;

import br.com.XPTO.core.domains.BankMovement;
import br.com.XPTO.infra.dtos.bankMovement.responses.BankMovementResponse;
import org.springframework.stereotype.Component;


@Component
public class BankMovementDtoMapper {
    public BankMovementResponse toDto(BankMovement bankMovement){
        return new BankMovementResponse(
                bankMovement.getId(),
                bankMovement.getValue(),
                bankMovement.getCreatedAt(),
                bankMovement.getCreditDebitIndicator()
        );
    }
}
