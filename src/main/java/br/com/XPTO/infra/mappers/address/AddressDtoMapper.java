package br.com.XPTO.infra.mappers.address;

import br.com.XPTO.core.domains.Address;
import br.com.XPTO.infra.dtos.address.request.AddressRequest;
import br.com.XPTO.infra.dtos.address.response.AddressResponse;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoMapper {
    public Address toDomain(AddressRequest request) {
        return new Address(
                null,
                request.getStreet(),
                request.getNumber(),
                request.getComplement(),
                request.getDistrict(),
                request.getCity(),
                request.getState(),
                request.getCep()
        );
    }

    public AddressResponse toDto(Address domain) {
        return new AddressResponse(
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
