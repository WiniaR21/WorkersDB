package com.WorkersDataBase.data.worker;

import com.WorkersDataBase.data.contact.Contact;
import com.WorkersDataBase.data.contract.Contract;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Table(name = "worker")
@NoArgsConstructor
@EqualsAndHashCode(exclude = "contract")
public class Worker {

    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "product_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id", foreignKey = @ForeignKey (name = "contact_fk"))
    private Contact contact;

    @Column(name = "pesel")
    private String pesel;

    @Column(name = "date_of_birth")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @OneToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "contract_fk"))
    private Contract contract;
    public Worker(String firstName, String lastName, String pesel, Contact contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.contact = contact;
    }

}
