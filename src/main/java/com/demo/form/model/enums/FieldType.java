package com.demo.form.model.enums;

public enum FieldType {
    TEXT("TEXT"),
    OPTION("OPTION"),
    MULTI_OPTION("MULTI_OPTION");

    private String description;

    FieldType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getName() {
        return description;
    }
}
