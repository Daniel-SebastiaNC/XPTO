package br.com.XPTO.infra.dtos.address.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddressResponse {
    private Long id;
    private String street;
    private int number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String cep;
}
