package com.microservice.trisoft.resource;


import com.microservice.trisoft.service.dto.TodoDto;
import com.microservice.trisoft.service.facade.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/todo")
public class TodoResource {

    @Autowired
    private Facade facade;

    @PostMapping
    public ResponseEntity<String> saveTodo(@RequestBody @Valid TodoDto todoDto)throws Exception{
        return ResponseEntity.ok(facade.service.todoService.save(todoDto));
    }

    @GetMapping
    public ResponseEntity<String> getAllTodo() throws Exception{
        return ResponseEntity.ok(facade.service.todoService.getAllTodo());
    }

    @GetMapping("/uuid")
    public ResponseEntity<TodoDto> getTodoByUuid() throws Exception{
        return ResponseEntity.ok(facade.service.todoService.getTodoByUuid());
    }
}
