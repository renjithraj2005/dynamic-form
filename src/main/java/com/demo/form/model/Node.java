package com.demo.form.model;

import com.demo.form.model.enums.FieldType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name =  "Node")
@Table(name = "node")
public class Node extends BaseModel {

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "field_label", nullable = false)
    private String fieldLabel;

    @Enumerated(EnumType.STRING)
    private FieldType type;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "point_id", nullable = false)
    private Point point;


    public Node() {
    }

    public Node(String fieldName, FieldType type, String fieldLabel) {
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

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }
}
