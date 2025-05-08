package br.com.XPTO.infra.mappers.account;

import br.com.XPTO.core.domains.Account;
import br.com.XPTO.infra.dtos.account.responses.AccountResponse;
import br.com.XPTO.infra.dtos.bankMovement.responses.BankMovementResponse;
import br.com.XPTO.infra.mappers.bankMovements.BankMovementDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountDtoMapper {

    private final BankMovementDtoMapper mapper;

    public AccountResponse toDto(Account domain){
        List<BankMovementResponse> bankMovementResponses = new ArrayList<>();
        if (domain.getBankMovements() != null && !domain.getBankMovements().isEmpty()) {
             bankMovementResponses = domain.getBankMovements().stream().map(mapper::toDto).collect(Collectors.toList());
        }

        return new AccountResponse(
                domain.getId(),
                domain.getBalance(),
                bankMovementResponses
        );
    }
}
