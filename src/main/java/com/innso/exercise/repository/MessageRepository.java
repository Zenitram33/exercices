package com.innso.exercise.repository;

import com.innso.exercise.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring Data repository for the Message entity.
 */
@RepositoryRestResource
public interface MessageRepository extends JpaRepository<Message, Long> {
}
