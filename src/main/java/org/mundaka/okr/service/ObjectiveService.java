package org.mundaka.okr.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mundaka.okr.entity.ObjectiveEntity;
import org.mundaka.okr.model.Objective;
import org.mundaka.okr.repository.ObjectiveRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
@AllArgsConstructor
@Slf4j
public class ObjectiveService {

    private final ObjectiveRepository objectiveRepository;
    private final ObjectiveMapper objectiveMapper;

    public List<Objective> findAll() {
        return this.objectiveMapper.toDomainList(objectiveRepository.findAll().list());
    }

    @Transactional
    public void save(@Valid Objective objective) {
        log.debug("Saving objective: {}", objective);
        ObjectiveEntity objectiveEntity = objectiveMapper.toEntity(objective);
        objectiveRepository.persist(objectiveEntity);
        objectiveMapper.updateDomainFromEntity(objectiveEntity,objective);
    }

    // TODO Implement the rest of methods
}
