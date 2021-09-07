package com.microservice.todo.service;

import com.microservice.todo.dtos.TodoDto;
import com.microservice.todo.models.Todo;
import com.microservice.todo.service.facade.RepositoryFacade;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TodoServiceImpl {

    @Autowired
    RepositoryFacade repository;

    public Todo save(TodoDto todoDto){
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoDto, todo);
        todo.setUuid(UUID.randomUUID().toString());
        return repository.todoRepository.save(todo);
    }

    public Page<Todo> findAll(Pageable pageable) {
        return repository.todoRepository.findAll(pageable);
    }
}
