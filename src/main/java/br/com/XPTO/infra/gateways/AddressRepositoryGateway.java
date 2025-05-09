package br.com.XPTO.infra.gateways;

import br.com.XPTO.core.domains.Address;
import br.com.XPTO.core.gateways.AddressGateway;
import br.com.XPTO.infra.mappers.address.AddressEntityMapper;
import br.com.XPTO.infra.persistence.entities.AddressEntity;
import br.com.XPTO.infra.persistence.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressRepositoryGateway implements AddressGateway {
    private final AddressRepository repository;
    private final AddressEntityMapper addressEntityMapper;

    @Override
    public Address updateAddress(Address address, Address addressUpdate) {
        AddressEntity addressEntity = addressEntityMapper.toEntity(address);
        addressEntity.setStreet((addressUpdate.getStreet() != null) ? addressUpdate.getStreet() : address.getStreet());
        addressEntity.setNumberHouse((addressUpdate.getNumber() != 0) ? addressUpdate.getNumber() : address.getNumber());
        addressEntity.setComplement((addressUpdate.getComplement() != null) ? addressUpdate.getComplement() : address.getComplement());
        addressEntity.setDistrict((addressUpdate.getDistrict() != null) ? addressUpdate.getDistrict() : address.getDistrict());
        addressEntity.setCity((addressUpdate.getCity() != null) ? addressUpdate.getCity() : address.getCity());
        addressEntity.setState((addressUpdate.getState() != null) ? addressUpdate.getState() : address.getState());
        addressEntity.setCep((addressUpdate.getCep() != null) ? addressUpdate.getCep() : address.getCep());

        return addressEntityMapper.toDomain(
                repository.save(addressEntity)
        );
    }

}
