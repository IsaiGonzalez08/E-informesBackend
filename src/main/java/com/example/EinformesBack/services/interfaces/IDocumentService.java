package com.example.EinformesBack.services.interfaces;

import com.example.EinformesBack.controllers.document.dtos.requests.CreateDocumentRequest;
import com.example.EinformesBack.controllers.document.dtos.requests.UpdateDocumentRequest;
import com.example.EinformesBack.controllers.document.dtos.responses.GetDocumentResponse;


import java.util.List;

public interface IDocumentService {
    List<GetDocumentResponse> list();
    GetDocumentResponse get(Long id);
    void create(CreateDocumentRequest request);
    GetDocumentResponse update(Long id, UpdateDocumentRequest request);
    void delete(Long id);
}
