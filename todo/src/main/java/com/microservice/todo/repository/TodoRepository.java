package com.microservice.todo.repository;

import com.microservice.todo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Todo findByUuid(@Param("uuid")String uuid);

}
