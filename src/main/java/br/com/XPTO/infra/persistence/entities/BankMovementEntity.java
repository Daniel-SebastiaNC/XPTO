package br.com.XPTO.infra.persistence.entities;

import br.com.XPTO.core.enums.CreditDebitIndicator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_bank_movement")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankMovementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
