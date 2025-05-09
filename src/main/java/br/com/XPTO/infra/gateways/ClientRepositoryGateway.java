package br.com.XPTO.infra.gateways;

import br.com.XPTO.core.domains.Client;
import br.com.XPTO.core.gateways.ClientGateway;
import br.com.XPTO.infra.mappers.client.ClientEntityMapper;
import br.com.XPTO.infra.persistence.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientRepositoryGateway implements ClientGateway {

    private final ClientRepository repository;
    private final ClientEntityMapper clientEntityMapper;

    @Override
    public Client saveClient(Client client) {
        return clientEntityMapper.toDomain(
                repository.save(
                       clientEntityMapper.toEntity(client)
                )
        );
    }

    @Override
    public Optional<Client> findClientByCpfCnpj(String cpfCnpj) {
        return repository.findClientByCpfCnpj(cpfCnpj).map(clientEntityMapper::toDomain);
    }


}
