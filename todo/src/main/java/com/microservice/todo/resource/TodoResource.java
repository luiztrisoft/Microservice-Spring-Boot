package com.microservice.todo.resource;

import com.microservice.todo.dtos.TodoDto;
import com.microservice.todo.models.Todo;
import com.microservice.todo.service.facade.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TodoResource {

    @Autowired
    Facade facade;

    @PostMapping
    public ResponseEntity<Todo> saveTodo(@RequestBody @Valid TodoDto todoDto){
        Todo todo = facade.service.todoService.save(todoDto);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Todo>> getAllTodos(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Todo> todo = facade.service.todoService.findAll(pageable);
        if(todo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }
    }

    @PostMapping("/find-by-uuid")
    public ResponseEntity<Todo> getTodoByUuid(@RequestBody TodoDto dto){
        return new ResponseEntity(facade.repository.todoRepository.findByUuid(dto.getUuid()), HttpStatus.OK);
    }

    //TODO IMPLEMENTAR O STATUS CRIADO, ANDAMENTO, FEITO, CANCELADO
}
