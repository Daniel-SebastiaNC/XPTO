package br.com.XPTO.infra.dtos.client.requests;

import br.com.XPTO.infra.dtos.address.request.AddressRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClientRequest {
    @NotNull(message = "required")
    private String name;

    @NotNull(message = "required")
    @Size(message = "min: 11 digits - max: 14 digits", min = 11, max = 14)
    private String cpfCnpj;

    @NotNull(message = "required")
    private AddressRequest address;

    @NotEmpty(message = "required")
    private List<Long> accounts;

    @NotNull(message = "required")
    @Pattern(regexp = "PJ|PF", message = "PJ or PF")
    private String taxIdentifiers;

    @NotNull(message = "required")
    @Size(message = "min: 11 digits - max: 14 digits", min = 16, max = 17)
    private String telephone;
}
