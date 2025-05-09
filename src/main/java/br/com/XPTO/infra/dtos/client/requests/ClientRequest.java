package br.com.XPTO.infra.dtos.client.requests;

import br.com.XPTO.core.enums.TaxIdentifiers;
import br.com.XPTO.infra.dtos.address.request.AddressRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClientRequest {
    private String name;
    private String cpfCnpj;
    private AddressRequest address;
    private List<Long> accounts;
    private TaxIdentifiers taxIdentifiers;
    private String telephone;
}
