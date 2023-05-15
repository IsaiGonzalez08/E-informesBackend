package com.example.EinformesBack.controllers.questionnarie;

import com.example.EinformesBack.controllers.questionnarie.dtos.requests.CreateQuestionnarieRequest;
import com.example.EinformesBack.controllers.questionnarie.dtos.requests.UpdateQuestionnarieRequest;
import com.example.EinformesBack.controllers.questionnarie.dtos.responses.GetQuestionnarieResponse;
import com.example.EinformesBack.services.interfaces.IQuestionnarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questionnarie")
public class QuestionnarieController {

    @Autowired
    private IQuestionnarieService service;

    @GetMapping("list")
    public List<GetQuestionnarieResponse> list() {
        return service.list();
    }
    @GetMapping("{id}")
    public GetQuestionnarieResponse get(@PathVariable Long id) {
        return service.get(id);
    }
    @PostMapping
    public void create(@RequestBody CreateQuestionnarieRequest request) {
        service.create(request);
    }
    @PutMapping("{id}")
    public GetQuestionnarieResponse update(@PathVariable Long id, @RequestBody UpdateQuestionnarieRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
