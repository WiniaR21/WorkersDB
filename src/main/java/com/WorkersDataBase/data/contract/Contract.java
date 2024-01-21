package com.WorkersDataBase.data.contract;

import com.WorkersDataBase.data.position.Position;
import com.WorkersDataBase.data.worker.Worker;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Table(name = "contract")
@NoArgsConstructor
public class Contract {
    @Id
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "product_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id",
                    foreignKey = @ForeignKey(
                            name = "position_fk"))
    private Position position;

    @Column(name = "salary")
    private Double salary;

    @ToString.Exclude
    @OneToOne(mappedBy = "contract")
    private Worker worker;
}
