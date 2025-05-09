package br.com.XPTO.infra.persistence.entities;

import br.com.XPTO.core.enums.TaxIdentifiers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", sequenceName = "seq_tb_client", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "cpf_cnpj", nullable = false, unique = true)
    private String cpfCnpj;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private AddressEntity address;

    @OneToMany(mappedBy = "client", orphanRemoval = true)
    @Column(nullable = false)
    private List<AccountEntity> accounts;

    @Column(name = "tax_identifier", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaxIdentifiers taxIdentifiers;

    @Column(nullable = false)
    private String telephone;

    @Column(name = "created_at",nullable = false)
    private LocalDate createdAt;

    @Column(name = "balance_total", nullable = false)
    private Double balanceTotal;
}
