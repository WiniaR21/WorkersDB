package com.WorkersDataBase.data.companyFee;

import com.WorkersDataBase.data.contract.Contract;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Table(name = "company_fee")
@NoArgsConstructor
public class CompanyFee {
    @Id
    @SequenceGenerator(name = "company_fee_sequence", sequenceName = "company_fee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "company_fee_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "skladka_emerytalna")
    private double skladkaEmerytalna;

    @Column(name = "skladka_rentowa")
    private double skladkaRentowa;

    @Column(name = "skladka_na_ubezpieczenie_wypadkowe")
    private double skladkaNaUbezpieczenieWypadkowe;

    @Column(name = "skladka_na_fundusz_pracy")
    private double skladkaNaFunduszPracy;

    @Column(name = "skladka_na_fgsp")
    private double skladkaNaFGSP;

    @Column(name = "laczne_koszty_pracodawcy")
    private double laczneKosztyPracodawcy;

    @OneToOne(mappedBy = "companyFee")
    Contract contract = new Contract();

    public CompanyFee(double salary) {
        skladkaEmerytalna = Math.round(setSkladkaEmerytalna(salary) * 100.0) / 100.0;
        skladkaRentowa = Math.round(setSkladkaRentowa(salary) * 100.0) / 100.0;
        skladkaNaUbezpieczenieWypadkowe = Math.round(setSkladkaNaUbezpieczenieWypadkowe(salary) * 100.0) / 100.0;
        skladkaNaFunduszPracy = Math.round(setSkladkaNaFunduszPracy(salary) * 100.0) / 100.0;
        skladkaNaFGSP = Math.round(setSkladkaNaFGSP(salary) * 100.0) / 100.0;
        laczneKosztyPracodawcy = Math.round(setLaczneKosztyPracodawcy(salary) * 100.0) / 100.0;

    }

    private double setSkladkaEmerytalna(double salary) {
        return skladkaEmerytalna = salary * 0.0976;
    }

    private double setSkladkaRentowa(double salary) {
        return skladkaRentowa = salary * 0.065;
    }

    private double setSkladkaNaUbezpieczenieWypadkowe(double salary) {
        return skladkaNaUbezpieczenieWypadkowe = salary * 0.0167;
    }

    private double setSkladkaNaFunduszPracy(double salary) {
        return skladkaNaFunduszPracy = salary * 0.0245;
    }

    private double setSkladkaNaFGSP(double salary) {
        return skladkaNaFGSP = salary * 0.001;
    }
    private double setLaczneKosztyPracodawcy(double salary){
        return skladkaEmerytalna +
                skladkaRentowa +
                skladkaNaUbezpieczenieWypadkowe +
                skladkaNaFunduszPracy +
                skladkaNaFGSP +
                salary;
    }
}
