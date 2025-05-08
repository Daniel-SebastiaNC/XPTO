package br.com.XPTO.infra.persistence.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "client")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "seq_tb_account", allocationSize = 1)
    private Long id;

    private Double balance;

    @OneToMany(mappedBy = "account")
    @Column(name = "bank_movements")
    List<BankMovementEntity> bankMovements;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
}
