package br.com.XPTO.core.usecases.client;

import br.com.XPTO.core.domains.Account;
import br.com.XPTO.core.domains.BankMovement;
import br.com.XPTO.core.domains.Client;
import br.com.XPTO.core.enums.CreditDebitIndicator;
import br.com.XPTO.core.gateways.ClientGateway;
import br.com.XPTO.infra.dtos.client.responses.ReportByClient;
import br.com.XPTO.infra.exceptions.DataNotFoundException;
import br.com.XPTO.infra.mappers.address.AddressDtoMapper;

import java.util.ArrayList;
import java.util.List;

public class ReportByClientUsecaseImpl implements ReportByClientUsecase {
    private final ClientGateway clientGateway;
    private final AddressDtoMapper addressDtoMapper;

    public ReportByClientUsecaseImpl(ClientGateway clientGateway, AddressDtoMapper addressDtoMapper) {
        this.clientGateway = clientGateway;
        this.addressDtoMapper = addressDtoMapper;
    }

    @Override
    public ReportByClient execute(Long id) {
        Client client = clientGateway.findClientById(id).orElseThrow(() -> new DataNotFoundException("Client Not Found"));

        List<BankMovement> creditMovements = new ArrayList<>();
        List<BankMovement> debitMovements = new ArrayList<>();
        Double oldBalance = 0.0;

        for (Account account : client.getAccounts()) {
            oldBalance += account.getBankMovements().get(0).getValue();
            for (BankMovement bankMovement : account.getBankMovements()) {
                if (bankMovement.getCreditDebitIndicator().equals(CreditDebitIndicator.CREDIT)) {
                    creditMovements.add(bankMovement);
                } else {
                    debitMovements.add(bankMovement);
                }
            }
        }

        return new ReportByClient(
                client.getName(),
                addressDtoMapper.toDto(client.getAddress()),
                client.getCreatedAt(),
                creditMovements.size(),
                debitMovements.size(),
                oldBalance,
                client.getBalanceTotal()
        );

    }
}
