package br.com.XPTO.infra.presentation;

import br.com.XPTO.core.usecases.account.CreateBankAccountUsecase;
import br.com.XPTO.core.usecases.account.MakeBankMovementUsecase;
import br.com.XPTO.infra.dtos.account.responses.AccountResponse;
import br.com.XPTO.infra.dtos.bankMovement.requests.BankMovementRequest;
import br.com.XPTO.infra.dtos.bankMovement.responses.BankMovementResponse;
import br.com.XPTO.infra.mappers.account.AccountDtoMapper;
import br.com.XPTO.infra.mappers.bankMovements.BankMovementDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final CreateBankAccountUsecase createBankAccountUsecase;
    private final MakeBankMovementUsecase makeBankMovementUsecase;

    private final AccountDtoMapper accountDtoMapper;
    private final BankMovementDtoMapper bankMovementDtoMapper;

    @PostMapping("/create")
    public ResponseEntity<AccountResponse> createBankAccount(){

        return ResponseEntity.status(HttpStatus.CREATED).body(
                accountDtoMapper.toDto(
                        createBankAccountUsecase.execute()
                )
        );
    }

    @PostMapping("/movement/{id}")
    public ResponseEntity<BankMovementResponse> movementCredit(@PathVariable Long id, @Valid @RequestBody BankMovementRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                bankMovementDtoMapper.toDto(
                        makeBankMovementUsecase.execute(id, bankMovementDtoMapper.toDomain(request)
                        )
                )
        );
    }
}