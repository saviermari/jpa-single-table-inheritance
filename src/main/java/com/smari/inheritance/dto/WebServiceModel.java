package com.smari.inheritance.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class WebServiceModel implements Serializable {
    private Long id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String serviceType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
