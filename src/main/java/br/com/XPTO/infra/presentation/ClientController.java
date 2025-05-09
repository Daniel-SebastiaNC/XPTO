package br.com.XPTO.infra.presentation;

import br.com.XPTO.core.usecases.client.CreateClientUsacase;
import br.com.XPTO.infra.dtos.client.requests.ClientRequest;
import br.com.XPTO.infra.dtos.client.responses.ClientResponse;
import br.com.XPTO.infra.mappers.client.ClientDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final CreateClientUsacase createClientUsacase;

    private final ClientDtoMapper clientDtoMapper;

    @PostMapping("/create")
    public ResponseEntity<ClientResponse> createClient( @Valid @RequestBody ClientRequest clientRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                clientDtoMapper.toDto(
                        createClientUsacase.execute(
                                clientDtoMapper.toDomain(clientRequest)
                        )
                )
        );
    }
}
