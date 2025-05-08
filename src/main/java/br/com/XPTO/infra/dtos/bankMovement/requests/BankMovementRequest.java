package br.com.XPTO.infra.dtos.bankMovement.requests;

import br.com.XPTO.core.enums.CreditDebitIndicator;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BankMovementRequest {
    private Double value;
    private CreditDebitIndicator creditDebitIndicator;
}
