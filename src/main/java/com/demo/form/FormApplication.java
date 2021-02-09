package com.demo.form;

import com.demo.form.model.Form;
import com.demo.form.model.FormField;
import com.demo.form.model.enums.FieldType;
import com.demo.form.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class FormApplication implements CommandLineRunner {

	@Autowired
	FormRepository formRepository;

	public static void main(String[] args) {
		SpringApplication.run(FormApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		FormField stringField =  new FormField("name", FieldType.TEXT,"what is your name?");
		FormField optionField = new FormField("gender",FieldType.OPTION,"what is your gender?");
		FormField multiOptionField = new FormField("hobbies",FieldType.MULTI_OPTION,"Select your hobbies?");

		Form form = new Form("userForm");
		stringField.setForm(form);
		optionField.setForm(form);
		multiOptionField.setForm(form);
		form.getFormFields().addAll(Stream.of(stringField, optionField,multiOptionField)
				.collect(Collectors.toCollection(HashSet::new)));
		formRepository.save(form);
	}

}
