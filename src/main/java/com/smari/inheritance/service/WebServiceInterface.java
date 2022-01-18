package com.smari.inheritance.service;

import com.smari.inheritance.dto.WebServiceModel;

import java.util.List;

public interface WebServiceInterface {
    WebServiceModel createWebService(WebServiceModel model);
    WebServiceModel updateWebService(WebServiceModel model);
    void deleteWebService(Long id);
    WebServiceModel getWebService(Long id);
    public List<WebServiceModel> getAllProducts();
}
