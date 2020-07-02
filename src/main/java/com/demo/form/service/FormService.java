package com.demo.form.service;

import com.demo.form.dao.SurveyAnswerStatistics;
import com.demo.form.model.FilledForm;
import com.demo.form.model.FormField;
import com.demo.form.repository.FilledFormRepository;
import com.demo.form.repository.FormFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FormService {

    @Autowired
    private FilledFormRepository filledFormRepository;

    @Autowired
    private FormFieldRepository formFieldRepository;

    public void processForm(MultiValueMap<String, String> postPayload, int formId){
        for (Map.Entry<String, List<String>> entry : postPayload.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            value.removeIf(item -> item == null || "".equals(item));

            if(!value.isEmpty()){
                FilledForm filledForm = new FilledForm(formId,key,value);
                filledFormRepository.save(filledForm);
            }

            mostAnsweredQuestion(formId);
            commonAnswer(formId);
        }
    }

    public void mostAnsweredQuestion(int formId){
        List<SurveyAnswerStatistics> result = filledFormRepository.findMostAnsweredQuestion(formId);
        if(!result.isEmpty()){

            Optional<FormField> formField = formFieldRepository.findById(Integer.parseInt(result.get(0).getField()));
            if(formField.isPresent()){
                System.out.println("Most Answered Question " + formField.get().getFieldLabel());
            }

        }
    }

    public void commonAnswer(int formId){
        List<SurveyAnswerStatistics> result = filledFormRepository.findCommonAnswer(formId);
        if(!result.isEmpty()){

            System.out.println("most common answer = " + result.get(0).getField());

        }
    }


}
