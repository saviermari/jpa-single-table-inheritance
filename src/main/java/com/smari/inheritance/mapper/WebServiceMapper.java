package com.smari.inheritance.mapper;

import com.smari.inheritance.dto.RestServiceModel;
import com.smari.inheritance.dto.SoapServiceModel;
import com.smari.inheritance.dto.WebServiceModel;
import com.smari.inheritance.entity.RestService;
import com.smari.inheritance.entity.SoapService;
import com.smari.inheritance.entity.WebService;
import org.springframework.stereotype.Component;

@Component
public class WebServiceMapper {
    public WebService convertModelToEntity(WebServiceModel model){
        WebService entity = model instanceof RestServiceModel ? new RestService() : new SoapService();
        if(model != null){
            if(null != model.getId()) {
                entity.setId(model.getId());
            }
            entity.setName(model.getName());
        }
        return entity;
    }

    public WebServiceModel convertEntityToModel(WebService entity){
        WebServiceModel model = entity instanceof RestService ? new RestServiceModel() : new SoapServiceModel();
        if(entity != null){
            if(null != entity.getId()) {
                model.setId(entity.getId());
            }
            model.setName(entity.getName());
        }
        return model;
    }
}
