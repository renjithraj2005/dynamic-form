package com.demo.form.repository;

import com.demo.form.model.FormField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormFieldRepository extends JpaRepository<FormField,Integer> {
}
