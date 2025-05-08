package br.com.XPTO.infra.dtos.account.responses;

import br.com.XPTO.infra.dtos.bankMovement.responses.BankMovementResponse;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class AccountResponse {
    private Long id;
    private Double balance;
    List<BankMovementResponse> bankMovements;
}
