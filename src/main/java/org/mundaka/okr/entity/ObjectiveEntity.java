package org.mundaka.okr.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "Objective")
@Table(name = "objective")
@Data
public class ObjectiveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "objective_id")
    private Integer objectiveId;

    @Column(name = "description")
    @NotEmpty
    public String description;
}
