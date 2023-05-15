package com.example.EinformesBack.services.interfaces;

import com.example.EinformesBack.controllers.questionnarie.dtos.requests.CreateQuestionnarieRequest;
import com.example.EinformesBack.controllers.questionnarie.dtos.requests.UpdateQuestionnarieRequest;
import com.example.EinformesBack.controllers.questionnarie.dtos.responses.GetQuestionnarieResponse;

import java.util.List;

public interface IQuestionnarieService {

    List<GetQuestionnarieResponse> list();
    GetQuestionnarieResponse get(Long id);
    void create(CreateQuestionnarieRequest request);
    GetQuestionnarieResponse update(Long id, UpdateQuestionnarieRequest request);
    void delete(Long id);
}
