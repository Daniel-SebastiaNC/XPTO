package br.com.XPTO.infra.persistence.repositories;

import br.com.XPTO.infra.persistence.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
