package br.com.XPTO.core.usecases.client;

import br.com.XPTO.core.domains.Account;
import br.com.XPTO.core.domains.Client;
import br.com.XPTO.core.enums.TaxIdentifiers;
import br.com.XPTO.core.gateways.AccountGateway;
import br.com.XPTO.core.gateways.ClientGateway;
import br.com.XPTO.infra.exceptions.*;

import java.time.LocalDate;
import java.util.List;

public class CreateClientUsacaseImpl implements CreateClientUsacase {

    private final ClientGateway clientGateway;
    private final AccountGateway accountGateway;

    public CreateClientUsacaseImpl(ClientGateway clientGateway, AccountGateway accountGateway) {
        this.clientGateway = clientGateway;
        this.accountGateway = accountGateway;
    }

    @Override
    public Client execute(Client client) {
        this.validation(client);

        client.setCreatedAt(LocalDate.now());
        Double newBalance = 0.0;

        for (Account account : client.getAccounts()) {
            newBalance += account.getBalance();
        }

        System.out.println(client.getAccounts());
        client.setBalanceTotal(newBalance);

        Client clientSave = clientGateway.saveClient(client);

        for (Account account : client.getAccounts()) {
            account.setClient(clientSave.getId());
            accountGateway.saveAccount(account);
        }

        return clientSave;
    }

    private void validation(Client client) {
        this.validationAccount(client.getAccounts());
        this.validationBankMovement(client.getAccounts());
        this.validationCpfCnpj(client.getCpfCnpj(), client.getTaxIdentifiers());
        this.validationTelephone(client.getTelephone());
    }

    private void validationAccount(List<Account> accounts) {
        if (accounts.isEmpty()) {
            throw new MustBeLinkedAccountException("Must have a linked account");
        }

        for (Account account : accounts) {
            if (account.getClient() != 0 && account.getClient() != null) {
                throw new AccountAlreadyLinked("The account is already linked to another Client.");
            }
        }
    }

    private void validationBankMovement(List<Account> accounts) {
        int sizeMovements = 0;
        for (Account account : accounts) {
            sizeMovements += account.getBankMovements().size();
        }
        if (sizeMovements == 0) {
            throw new NoMovementAccountException("No movements in the account. You need to have at least one movement in the account.");
        }
    }

    private void validationCpfCnpj(String cpfCnpj, TaxIdentifiers taxIdentifiers) {
        switch (taxIdentifiers){
            case PJ:
                if (cpfCnpj.length() != 14) {
                    throw new CpfOrCnpjInvalidException("CNPJ must have 12 digits");
                }
                break;
            case PF:
                if (cpfCnpj.length() != 11) {
                    throw new CpfOrCnpjInvalidException("CPF must have 9 digits");
                }
                break;
        }

        if (clientGateway.findClientByCpfCnpj(cpfCnpj).isPresent()) {
            switch (taxIdentifiers){
                case PJ:
                    throw new CpfOrCnpjInvalidException("CNPJ CPF already exists");
                case PF:
                    throw new CpfOrCnpjInvalidException("CPF already exists");
            }
        }
    }

    private void validationTelephone(String telephone) {
        /*"+551 87 991899798"*/
        String[] split = telephone.split(" ");
        if (telephone.length() != 16 && telephone.length() != 17) {
            throw new TelephoneInvalidException("Telephone invalid, please insert a phone for this format - +111 11 123451234");
        }

        String ddd = split[0];
        String opr = split[1];
        String number = split[2];

        if (!ddd.contains("+") || (ddd.length() != 4 && ddd.length() != 3) ) {
            throw new TelephoneInvalidException("DDD invalid, please insert a phone for this format - +111 11 123451234");
        }  else if (opr.length() != 2) {
            throw new TelephoneInvalidException("Opr invalid, Please insert a phone for this format - +111 11 123451234");
        } else if (number.length() !=  9) {
            throw new TelephoneInvalidException("number invalid, please insert a phone for this format - +111 11 123451234");
        }

    }
}
