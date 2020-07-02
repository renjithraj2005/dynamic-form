package com.demo.form.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name =  "FilledForm")
@Table(name = "filled_form")
public class FilledForm extends BaseModel{

    @Column(name = "form_id", nullable = false)
    private int formId;

    @Column(name = "field_id", nullable = false)
    private String fieldId;

    @Column(name = "value", nullable = false)
    private String value;

    public FilledForm(int formId, String fieldId, List<String> value) {
        this.formId = formId;
        this.fieldId = fieldId;
        if(value.size() == 1){
            this.value = value.get(0);
        }else {
            this.value = String.join(",", value);
        }

    }

    public FilledForm() {
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
