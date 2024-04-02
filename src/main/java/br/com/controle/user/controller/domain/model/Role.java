package br.com.controle.user.controller.domain.model;


import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat
public enum Role {
    WRITE_WORD("Write Word"),
    READ_WORD("Read Word"),
    WRITE_EXCEL("Write Excel"),
    READ_EXCEL("Read Excel"),
    ADMIN("Admin");

    private final String resourceName;

    Role(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }
}
