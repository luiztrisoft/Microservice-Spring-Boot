package com.microservice.trisoft.service;

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

    public String getTodoByUuid() throws Exception{
        TodoDto dto = new TodoDto("c78c58ab-0f42-4696-a390-53c0c981de84");
        ResponseEntity<String> result =  restUtil.post(todoMicroserviceUrl.concat("/find-by-uuid"), dto, null);
        return result.getBody();
    }

}
