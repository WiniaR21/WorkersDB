package com.WorkersDataBase.data.contract.worker.contact;

import com.WorkersDataBase.data.contract.worker.Worker;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Table(name = "contact")
@NoArgsConstructor
@EqualsAndHashCode(exclude = "worker")
public class Contact {

    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "product_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email")
    private String email;

    @ToString.Exclude
    @JsonIgnore
    @OneToOne(mappedBy = "contact")
    private Worker worker;

    public Contact(String email) {
        this.email = email;
    }



}
