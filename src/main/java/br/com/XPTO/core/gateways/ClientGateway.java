package br.com.XPTO.core.gateways;

import br.com.XPTO.core.domains.Client;

import java.util.Optional;

public interface ClientGateway {
    Client saveClient(Client client);

    Optional<Client> findClientByCpfCnpj(String cpfCnpj);

    Optional<Client> findClientById(Long id);
}
