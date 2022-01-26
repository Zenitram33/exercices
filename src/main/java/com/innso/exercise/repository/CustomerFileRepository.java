package com.innso.exercise.repository;

import com.innso.exercise.model.CustomerFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring Data repository for the Customer File entity.
 */
@RepositoryRestResource
public interface CustomerFileRepository extends CrudRepository<CustomerFile, Long> {
}
