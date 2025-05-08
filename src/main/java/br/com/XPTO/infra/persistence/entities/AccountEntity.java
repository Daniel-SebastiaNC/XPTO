package br.com.XPTO.infra.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double balance;

    @OneToMany(mappedBy = "account")
    @Column(name = "bank_movements")
    List<BankMovementEntity> bankMovements;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
}
