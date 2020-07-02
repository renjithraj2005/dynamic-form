package com.demo.form.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name =  "Form")
@Table(name = "form")
public class Form extends BaseModel{
    @Column(name = "name", nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "form", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FormField> formFields;

    public Form() {
    }

    public Form(String name) {
        this.name = name;
        this.formFields = new HashSet<FormField>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<FormField> getFormFields() {
        return formFields;
    }

    public void setFormFields(Set<FormField> formFields) {
        this.formFields = formFields;
    }
}
