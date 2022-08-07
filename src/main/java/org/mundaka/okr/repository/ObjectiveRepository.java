package org.mundaka.okr.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.mundaka.okr.entity.ObjectiveEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ObjectiveRepository implements PanacheRepositoryBase <ObjectiveEntity, Integer> {
}
