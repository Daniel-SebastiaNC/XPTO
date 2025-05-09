package br.com.XPTO.infra.dtos.client.responses;

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
public class ReportByClient {
    private String name;
    private AddressResponse address;
    private LocalDate createdAt;
    private Integer creditMovements;
    private Integer debitMovements;
    /*private Double value;*/
    private Double oldBalance;
    private Double todayBalance;
}
