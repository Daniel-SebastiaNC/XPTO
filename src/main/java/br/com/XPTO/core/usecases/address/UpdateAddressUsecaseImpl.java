package br.com.XPTO.core.usecases.address;

import br.com.XPTO.core.domains.Address;
import br.com.XPTO.core.domains.Client;
import br.com.XPTO.core.gateways.AddressGateway;
import br.com.XPTO.core.gateways.ClientGateway;
import br.com.XPTO.infra.exceptions.DataNotFoundException;

public class UpdateAddressUsecaseImpl implements UpdateAddressUsecase {

    private final ClientGateway clientGateway;
    private final AddressGateway addressGateway;

    public UpdateAddressUsecaseImpl(ClientGateway clientGateway, AddressGateway addressGateway) {
        this.clientGateway = clientGateway;
        this.addressGateway = addressGateway;
    }

    @Override
    public Address execute(Long id, Address address) {
        Client client = clientGateway.findClientById(id).orElseThrow(() -> new DataNotFoundException("Client Not Found"));
        return addressGateway.updateAddress(client.getAddress(), address);
    }
}
