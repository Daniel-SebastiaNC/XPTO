package br.com.XPTO.infra.dtos.bankMovement.responses;

import br.com.XPTO.core.enums.CreditDebitIndicator;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BankMovementResponse {
    private Long id;
    private Double value;
    private LocalDate createdAt;
    private CreditDebitIndicator creditDebitIndicator;
}
