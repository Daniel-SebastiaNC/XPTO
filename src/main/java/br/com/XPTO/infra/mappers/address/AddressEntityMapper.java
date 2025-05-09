package br.com.XPTO.infra.mappers.address;

import br.com.XPTO.core.domains.Address;
import br.com.XPTO.infra.persistence.entities.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityMapper {
    public Address toDomain(AddressEntity entity) {
        return new Address(
                entity.getId(),
                entity.getStreet(),
                entity.getNumberHouse(),
                entity.getComplement(),
                entity.getDistrict(),
                entity.getCity(),
                entity.getState(),
                entity.getCep()
        );
    }

    public AddressEntity toEntity(Address domain) {
        return new AddressEntity(
                domain.getId(),
                domain.getStreet(),
                domain.getNumber(),
                domain.getComplement(),
                domain.getDistrict(),
                domain.getCity(),
                domain.getState(),
                domain.getCep()
        );
    }
}
