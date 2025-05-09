package br.com.XPTO.infra.mappers.bankMovements;

import br.com.XPTO.core.domains.BankMovement;
import br.com.XPTO.core.enums.CreditDebitIndicator;
import br.com.XPTO.infra.dtos.bankMovement.requests.BankMovementRequest;
import br.com.XPTO.infra.dtos.bankMovement.responses.BankMovementResponse;
import org.springframework.stereotype.Component;

@Component
public class BankMovementDtoMapper {
    public BankMovement toDomain(BankMovementRequest request){
        return new BankMovement(
                null,
                request.getValue(),
                null,
                CreditDebitIndicator.valueOf(request.getCreditDebitIndicator()),
                null
        );
    }

    public BankMovementResponse toDto(BankMovement bankMovement){
        return new BankMovementResponse(
                bankMovement.getId(),
                bankMovement.getValue(),
                bankMovement.getCreatedAt(),
                bankMovement.getCreditDebitIndicator()
        );
    }
}
