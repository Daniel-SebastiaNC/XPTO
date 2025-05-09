package br.com.XPTO.core.usecases.address;

import br.com.XPTO.core.domains.Address;

public interface UpdateAddressUsecase {
    Address execute(Long id, Address address);
}
