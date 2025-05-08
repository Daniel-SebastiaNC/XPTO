package br.com.XPTO.infra.persistence.repositories;

import br.com.XPTO.infra.persistence.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
