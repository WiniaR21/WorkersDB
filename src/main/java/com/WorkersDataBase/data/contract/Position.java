package com.WorkersDataBase.data.contract;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Table(name = "position")
@NoArgsConstructor
public class Position {
    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "product_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "position_name")
    private String positionName;

    @OneToMany(mappedBy = "position",orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Contract> contracts = new ArrayList<>();
}
