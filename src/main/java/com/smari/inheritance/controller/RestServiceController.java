package com.smari.inheritance.controller;

import com.smari.inheritance.dto.RestServiceModel;
import com.smari.inheritance.dto.SoapServiceModel;
import com.smari.inheritance.dto.WebServiceModel;
import com.smari.inheritance.service.WebServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/rest/v1/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class RestServiceController {
    @Autowired
    private WebServiceInterface service;

    @PostMapping("/restServices")
    public WebServiceModel createService(@RequestBody RestServiceModel model) {
        return service.createWebService(model);
    }
    @PutMapping("/restServices/{id}")
    public WebServiceModel updateService(@RequestBody RestServiceModel model, @PathVariable Long id){
        WebServiceModel restService = service.getWebService(id);
        if(service == null){
            throw new RuntimeException("Not found");
        }
        if(model != null) if (null == model.getId()) {
            model.setId(restService.getId());
        }
        return service.updateWebService(model);
    }

    @DeleteMapping("/restServices/{id}")
    public void deleteService(@PathVariable Long id){
        service.deleteWebService(id);
    }

    @GetMapping("/restServices/{id}")
    public WebServiceModel getService(@PathVariable Long id){
        return service.getWebService(id);
    }
    @GetMapping("/restServices")
    public List<WebServiceModel> getAllServices(){
        return service.getAllWebServices().stream().filter(model->model.getServiceType().equals("REST")).collect(Collectors.toList());
    }
}
