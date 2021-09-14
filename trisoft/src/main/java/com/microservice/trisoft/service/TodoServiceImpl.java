package com.microservice.trisoft.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.microservice.trisoft.service.dto.TodoDto;
import com.microservice.trisoft.service.facade.Facade;
import com.microservice.trisoft.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl {

    @Value("${url.todo.service}")
    private String todoMicroserviceUrl;

    @Autowired
    private RestUtil restUtil;

    @Autowired
    private Facade facade;

    public String save(TodoDto todoDto) throws Exception{
        ResponseEntity<String> result = restUtil.post(todoMicroserviceUrl.concat("/"), todoDto, null);
        return result.getBody();
    }

    public String getAllTodo() throws Exception{
        ResponseEntity<String> result =  restUtil.get(todoMicroserviceUrl.concat("/"), null, null);
        return result.getBody();
    }

    public TodoDto getTodoByUuid() throws Exception{
        ResponseEntity<String> result =  restUtil.post(todoMicroserviceUrl.concat("/find-by-uuid"), new TodoDto("c78c58ab-0f42-4696-a390-53c0c981de84"), null);
        Gson g = new Gson();
        return g.fromJson(result.getBody(), TodoDto.class);
    }

}
