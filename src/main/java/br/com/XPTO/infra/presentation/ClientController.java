package br.com.XPTO.infra.presentation;

import br.com.XPTO.core.usecases.address.UpdateAddressUsecase;
import br.com.XPTO.core.usecases.client.CreateClientUsacase;
import br.com.XPTO.infra.dtos.address.request.AddressRequest;
import br.com.XPTO.infra.dtos.address.response.AddressResponse;
import br.com.XPTO.infra.dtos.client.requests.ClientRequest;
import br.com.XPTO.infra.dtos.client.responses.ClientResponse;
import br.com.XPTO.infra.mappers.address.AddressDtoMapper;
import br.com.XPTO.infra.mappers.client.ClientDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final CreateClientUsacase createClientUsacase;
    private final UpdateAddressUsecase updateAddressUsecase;

    private final ClientDtoMapper clientDtoMapper;
    private final AddressDtoMapper addressDtoMapper;

    @PostMapping("/create")
    public ResponseEntity<ClientResponse> createClient(@Valid @RequestBody ClientRequest clientRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                clientDtoMapper.toDto(
                        createClientUsacase.execute(
                                clientDtoMapper.toDomain(clientRequest)
                        )
                )
        );
    }

    @PatchMapping("/update-address/{id}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable Long id, @Valid @RequestBody AddressRequest addressRequest) {
         return ResponseEntity.ok(addressDtoMapper.toDto(
                        updateAddressUsecase.execute(id, addressDtoMapper.toDomain(addressRequest))
                )
        );
    }
}
