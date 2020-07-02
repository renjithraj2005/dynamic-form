package com.demo.form.repository;

import com.demo.form.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form,Integer> {
}
