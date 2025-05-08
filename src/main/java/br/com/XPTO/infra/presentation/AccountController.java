package br.com.XPTO.infra.presentation;

import br.com.XPTO.core.usecases.account.CreateBankAccountUsecase;
import br.com.XPTO.infra.dtos.account.responses.AccountResponse;
import br.com.XPTO.infra.mappers.account.AccountDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final CreateBankAccountUsecase createBankAccountUsecase;

    private final AccountDtoMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<AccountResponse> createBankAccount(){

        return ResponseEntity.status(HttpStatus.CREATED).body(
                mapper.toDto(
                        createBankAccountUsecase.execute()
                )
        );
    }
}