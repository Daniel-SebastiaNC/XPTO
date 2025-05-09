package br.com.XPTO.infra.dtos.bankMovement.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BankMovementRequest {
    @NotNull(message = "required")
    @Positive(message = "value positive")
    private Double value;

    @NotNull(message = "required")
    @Pattern(regexp = "CREDIT|DEBIT", message = "CREDIT or DEBIT")
    private String creditDebitIndicator;
}
