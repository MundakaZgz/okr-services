package org.mundaka.okr.service;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mundaka.okr.entity.ObjectiveEntity;
import org.mundaka.okr.model.Objective;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ObjectiveMapper {

    List<Objective> toDomainList(List<ObjectiveEntity> entities);

    Objective toDomain(ObjectiveEntity entity);

    @InheritInverseConfiguration(name = "toDomain")
    ObjectiveEntity toEntity(Objective domain);

    void updateEntityFromDomain(Objective domain, @MappingTarget ObjectiveEntity entity);

    void updateDomainFromEntity(ObjectiveEntity entity, @MappingTarget Objective domain);
}
