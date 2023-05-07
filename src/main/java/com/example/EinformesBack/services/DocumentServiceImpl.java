package com.example.EinformesBack.services;

import com.example.EinformesBack.controllers.document.dtos.requests.CreateDocumentRequest;
import com.example.EinformesBack.controllers.document.dtos.requests.UpdateDocumentRequest;
import com.example.EinformesBack.controllers.document.dtos.responses.GetDocumentResponse;
import com.example.EinformesBack.entities.Document;
import com.example.EinformesBack.repositories.IDocumentRepository;
import com.example.EinformesBack.services.interfaces.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements IDocumentService {

    @Autowired
    private IDocumentRepository repository;
    @Override
    public List<GetDocumentResponse> list() {
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
    @Override
    public GetDocumentResponse get(Long id) {
        return from(id);
    }
    private GetDocumentResponse from(Long idDocument){
        return repository.findById(idDocument)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("El usuario no existe"));
    }
    private GetDocumentResponse from(Document document) {
        GetDocumentResponse response = new GetDocumentResponse();
        response.setId_Document(document.getId_Document());
        response.setName_Document(document.getName_Document());
        return response;
    }
    @Override
    public void create(CreateDocumentRequest request) {
        Document document = from(request);
        repository.save(document);
    }
    private Document from(CreateDocumentRequest request) {
        Document document = new Document();
        document.setName_Document(request.getName_document());
        return document;
    }
    @Override
    public GetDocumentResponse update(Long id, UpdateDocumentRequest request) {
        Document document = findOneAndEnsureExist(id);
        document = update(document, request);
        return from(document);
    }
    private Document update(Document document, UpdateDocumentRequest request) {
        document.setName_Document(request.getName_document());
        return  repository.save(document);
    }
    private Document findOneAndEnsureExist(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("El documento no existe"));
    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
