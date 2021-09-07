package com.microservice.todo.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_todo")
public class Todo implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String uuid;
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String texto;

}
