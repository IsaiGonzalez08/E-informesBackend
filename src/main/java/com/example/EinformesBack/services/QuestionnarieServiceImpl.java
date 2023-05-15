package com.example.EinformesBack.services;

import com.example.EinformesBack.controllers.questionnarie.dtos.requests.CreateQuestionnarieRequest;
import com.example.EinformesBack.controllers.questionnarie.dtos.requests.UpdateQuestionnarieRequest;
import com.example.EinformesBack.controllers.questionnarie.dtos.responses.GetQuestionnarieResponse;
import com.example.EinformesBack.entities.Questionnarie;
import com.example.EinformesBack.repositories.IQuestionnarieRepository;
import com.example.EinformesBack.services.interfaces.IQuestionnarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionnarieServiceImpl implements IQuestionnarieService {
    @Autowired
    private IQuestionnarieRepository repository;
    @Override
    public List<GetQuestionnarieResponse> list() {
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
    @Override
    public GetQuestionnarieResponse get(Long id) {
        return from(id);
    }
    private GetQuestionnarieResponse from(Long idQuestionnarie){
        return repository.findById(idQuestionnarie)
                .map(this::from)
                .orElseThrow(() -> new RuntimeException("El questionario no existe"));
    }
    private GetQuestionnarieResponse from(Questionnarie questionnarie) {
        GetQuestionnarieResponse response = new GetQuestionnarieResponse();
        response.setId_Questionnarie(questionnarie.getId_Questionnarie());
        response.setName_Questionnarie(questionnarie.getName_Questionnarie());
        return response;
    }
    @Override
    public void create(CreateQuestionnarieRequest request) {
        Questionnarie questionnarie = from(request);
        repository.save(questionnarie);
    }
    private Questionnarie from(CreateQuestionnarieRequest request) {
        Questionnarie questionnarie = new Questionnarie();
        questionnarie.setName_Questionnarie(request.getName_Questionnarie());
        return questionnarie;
    }

    @Override
    public GetQuestionnarieResponse update(Long id, UpdateQuestionnarieRequest request) {
        Questionnarie questionnarie= findOneAndEnsureExist(id);
        questionnarie = update(questionnarie, request);
        return from(questionnarie);
    }
    private Questionnarie update(Questionnarie questionnarie, UpdateQuestionnarieRequest request) {
        questionnarie.setName_Questionnarie(request.getNameQuestionnarie());
        return  repository.save(questionnarie);
    }
    private Questionnarie findOneAndEnsureExist(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("El documento no existe"));
    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
