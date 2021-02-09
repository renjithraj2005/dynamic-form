package com.demo.form.model;

import com.demo.form.model.enums.FieldType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name =  "FormField")
@Table(name = "form_field")
public class FormField extends BaseModel {

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "field_label", nullable = false)
    private String fieldLabel;

    @Enumerated(EnumType.STRING)
    private FieldType type;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "form_id", nullable = false)
    private Form form;


    public FormField() {
    }

    public FormField(String fieldName, FieldType type, String fieldLabel) {
        this.fieldName = fieldName;
        this.fieldLabel = fieldLabel;
        this.type = type;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }
}
