package br.com.XPTO.infra.persistence.entities;

import br.com.XPTO.core.enums.CreditDebitIndicator;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_bank_movement")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "account")
public class BankMovementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_movement_seq")
    @SequenceGenerator(name = "bank_movement_seq", sequenceName = "seq_tb_bank_movement", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private Double value;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "credit_debit_indicator", nullable = false)
    @Enumerated(EnumType.STRING)
    private CreditDebitIndicator creditDebitIndicator;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;
}
