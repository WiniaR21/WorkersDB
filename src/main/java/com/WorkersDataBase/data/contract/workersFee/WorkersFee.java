package com.WorkersDataBase.data.contract.workersFee;

import com.WorkersDataBase.data.contract.Contract;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.RoundingMode;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Table(name = "workers_fee")
@NoArgsConstructor
public class WorkersFee {
    @Id
    @SequenceGenerator(name = "workers_fee_sequence", sequenceName = "workers_fee_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "workers_fee_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @OneToOne(mappedBy = "workersFee")
    Contract contract = new Contract();

    @Column(name = "skladka_emerytalna")
    private double skladkaEmerytalna;

    @Column(name = "skladka_rentowa")
    private double skladkaRentowa;

    @Column(name = "skladka_na_ubezpieczenie_chorobowe")
    private double skladkaNaUbezpieczenieChorobowe;

    @Column(name = "podstawa_wymiaru_skladki_na_ubezpieczenie_zdrowotne")
    private double podstawaNaUbezpieczenieZdrowotne;

    @Column(name = "skladka_na_ubezpieczenie_zdrowotne")
    private double skladkaNaUbezpieczenieZdrowotne;

    @Column(name = "podstawa_na_podatek_dochodowy")
    private double podstawaNaPodatekDochodowy;

    @Column(name = "koszty_uzyskania_przychodu")
    private double kosztyUzyskaniaPrzychodu;

    @Column(name = "zaliczka_na_podatek_dochodowy")
    private double zaliczkaNaPodatekDochodowy;

    @Column(name = "kwota_do_wyplaty_dla_pracownika")
    private double kwotaDoWyplatyDlaPracownika;

    public WorkersFee(double salary, int age) {
        skladkaEmerytalna = Math.round(setSkladkaEmerytalna(salary) * 100.0) / 100.0;
        skladkaRentowa = Math.round(setSkladkaRentowa(salary) * 100.0) / 100.0;
        skladkaNaUbezpieczenieChorobowe = Math.round(setSkladkaNaUbezpieczenieChorobowe(salary) * 100.0) / 100.0;
        podstawaNaUbezpieczenieZdrowotne = Math.round(setPodstawaNaUbezpieczenieZdrowotne(salary) * 100.0) / 100.0;
        skladkaNaUbezpieczenieZdrowotne = Math.round(setSkladkaNaUbezpieczenieZdrowotne() * 100.0) / 100.0;
        kosztyUzyskaniaPrzychodu = Math.round(setKosztyUzyskaniaPrzychodu(age) * 100.0) / 100.0;
        podstawaNaPodatekDochodowy = Math.round(setPodstawaNaPodatekDochodowy(salary));
        zaliczkaNaPodatekDochodowy = Math.round(setZaliczkaNaPodatekDochodowy(age));
        kwotaDoWyplatyDlaPracownika = Math.round(setKwotaDoWyplatyDlaPracownika(salary) * 100.0) / 100.0;

    }

    private double setSkladkaEmerytalna(double salary) {
        return salary * 0.0976;
    }

    private double setSkladkaRentowa(double salary) {
        return salary * 0.015;
    }

    private Double setSkladkaNaUbezpieczenieChorobowe(double salary) {
        return salary * 0.0245;
    }

    private double setPodstawaNaUbezpieczenieZdrowotne(double salary) {
        return  salary -
                skladkaEmerytalna -
                skladkaRentowa -
                skladkaNaUbezpieczenieChorobowe;
    }

    private double setSkladkaNaUbezpieczenieZdrowotne() {
        return podstawaNaUbezpieczenieZdrowotne * 0.09;
    }

    private double setKosztyUzyskaniaPrzychodu(int age)
    {
        return age >= 26 ? 250 : 0;
    }

    private double setPodstawaNaPodatekDochodowy(double salary) {
        return  salary -
                skladkaEmerytalna -
                skladkaRentowa -
                skladkaNaUbezpieczenieChorobowe -
                kosztyUzyskaniaPrzychodu;
    }

    private double setZaliczkaNaPodatekDochodowy(int age) {

        return age >= 26 ? (0.12 * podstawaNaPodatekDochodowy) - 300 : 0;
    }

    public double setKwotaDoWyplatyDlaPracownika(double salary) {
        return  salary -
                skladkaEmerytalna -
                skladkaRentowa -
                skladkaNaUbezpieczenieChorobowe -
                skladkaNaUbezpieczenieZdrowotne -
                zaliczkaNaPodatekDochodowy;
    }
}
