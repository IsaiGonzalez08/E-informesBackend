package com.example.EinformesBack.controllers.document;

import com.example.EinformesBack.controllers.document.dtos.requests.CreateDocumentRequest;
import com.example.EinformesBack.controllers.document.dtos.requests.UpdateDocumentRequest;
import com.example.EinformesBack.controllers.document.dtos.responses.GetDocumentResponse;
import com.example.EinformesBack.controllers.user.dtos.request.UpdateUserRequest;
import com.example.EinformesBack.services.interfaces.IDocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("documents")
public class DocumentController {

    @Autowired
    private IDocumentService service;

    @GetMapping("list")
    public List<GetDocumentResponse> list() {
        return service.list();
    }

    @GetMapping("{id}")
    public GetDocumentResponse getDocument(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public void create(@RequestBody CreateDocumentRequest request) {
        service.create(request);
    }

    @PutMapping("{id}")
    public GetDocumentResponse update(@PathVariable Long id, @RequestBody UpdateDocumentRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
