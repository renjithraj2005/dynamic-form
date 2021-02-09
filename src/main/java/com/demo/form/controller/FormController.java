package com.demo.form.controller;

import com.demo.form.model.Point;
import com.demo.form.repository.NodeRepository;
import com.demo.form.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Controller
public class FormController {

    @Autowired
    NodeRepository nodeRepository;

    @Autowired
    FormService formService;

    @GetMapping("/")
    public String formController(Model model) {
//        Optional<Point> form = nodeRepository.findById(1);
//        if(form.isPresent()){
//            model.addAttribute("form", form.get());
//        }
        return "form";
    }


    @PostMapping(value = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String process(@RequestBody MultiValueMap<String, String> postPayload, Model model) {

        List<String> id = postPayload.get("id");
//        if(!id.isEmpty()){
//            int formId = Integer.parseInt(id.get(0));
//            Optional<Point> form = nodeRepository.findById(formId);
//            form.ifPresent(value -> model.addAttribute("form", value));
//            postPayload.remove("id");
//            System.out.println(postPayload);
//            formService.processForm(postPayload,formId);
//        }

        model.addAttribute("success", true);
        return "form";
    }
}
