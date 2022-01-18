package com.smari.inheritance.controller;

import com.smari.inheritance.dto.SoapServiceModel;
import com.smari.inheritance.dto.WebServiceModel;
import com.smari.inheritance.service.WebServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/v1/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class SoapServiceController {
    @Autowired
    private WebServiceInterface service;

    @PostMapping("/soapServices")
    public WebServiceModel createCustomer(@RequestBody SoapServiceModel model) {
        return service.createWebService(model);
    }
    @DeleteMapping("/soapServices/{id}")
    public void deleteProduct(@PathVariable Long id){
        service.deleteWebService(id);
    }

    @GetMapping("/soapServices/{id}")
    public WebServiceModel getProduct(@PathVariable Long id){
        return service.getWebService(id);
    }

}
