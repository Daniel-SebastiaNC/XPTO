package br.com.XPTO.infra.persistence.repositories;

import br.com.XPTO.infra.persistence.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
