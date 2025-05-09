package br.com.XPTO.infra.dtos.address.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddressRequest {
    @NotNull(message = "required")
    private String street;

    @NotNull(message = "required")
    private int number;

    private String complement;

    @NotNull(message = "required")
    private String district;

    @NotNull(message = "required")
    private String city;

    @NotNull(message = "required")
    @Size(message = "2 digits", min = 2, max = 2)
    private String state;

    @NotNull(message = "required")
    @Size(message = "8 digits", min = 8, max = 8)
    private String cep;
}
