package br.com.XPTO.infra.persistence.repositories;

import br.com.XPTO.core.domains.Client;
import br.com.XPTO.infra.persistence.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findClientByCpfCnpj(String cpfCnpj);
}
