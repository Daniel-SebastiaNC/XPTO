package br.com.XPTO.infra.dtos.client.responses;

import br.com.XPTO.core.enums.TaxIdentifiers;
import br.com.XPTO.infra.dtos.account.responses.AccountResponse;
import br.com.XPTO.infra.dtos.address.response.AddressResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClientResponse {
    private Long id;
    private String name;
    private String cpfCnpj;
    private AddressResponse address;
    private List<AccountResponse> accounts;
    private TaxIdentifiers taxIdentifiers;
    private String telephone;
    private LocalDate createdAt;
    private Double balanceTotal;
}
