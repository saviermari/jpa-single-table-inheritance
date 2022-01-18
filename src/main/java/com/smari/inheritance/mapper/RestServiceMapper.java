package com.smari.inheritance.mapper;

import com.smari.inheritance.dto.RestServiceModel;
import com.smari.inheritance.dto.SoapServiceModel;
import com.smari.inheritance.entity.RestService;
import com.smari.inheritance.entity.SoapService;
import org.springframework.stereotype.Component;

@Component
public class RestServiceMapper {
    public RestService convertModelToEntity(RestServiceModel model){
        RestService entity = new RestService();
        if(model != null){
            if(null != model.getId()) {
                entity.setId(model.getId());
            }
            entity.setName(model.getName());
            entity.setProtocol(model.getProtocol());
        }
        return entity;
    }

    public  RestServiceModel convertEntityToModel(RestService entity){
        RestServiceModel model = new RestServiceModel();
        if(entity != null){
            if(null != entity.getId()) {
                model.setId(entity.getId());
            }
            model.setName(entity.getName());
            model.setProtocol(entity.getProtocol());
        }
        return model;
    }
}
