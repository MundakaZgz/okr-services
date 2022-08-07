package org.mundaka.okr.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Objective {
    private Integer objectiveId;

    @NotEmpty
    public String description;

}
