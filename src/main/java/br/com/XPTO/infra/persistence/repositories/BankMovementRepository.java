package br.com.XPTO.infra.persistence.repositories;

import br.com.XPTO.infra.persistence.entities.BankMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankMovementRepository extends JpaRepository<BankMovementEntity, Long> {
}
