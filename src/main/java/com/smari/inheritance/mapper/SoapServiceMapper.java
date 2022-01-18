package com.smari.inheritance.mapper;

import com.smari.inheritance.dto.SoapServiceModel;
import com.smari.inheritance.entity.SoapService;
import org.springframework.stereotype.Component;

@Component
public class SoapServiceMapper {

    public SoapService convertModelToEntity(SoapServiceModel model){
        SoapService entity = new SoapService();
        if(model != null){
            if(null != model.getId()) {
                entity.setId(model.getId());
            }
            entity.setName(model.getName());
            entity.setMetadata(model.getMetaData());
        }
        return entity;
    }

    public  SoapServiceModel convertEntityToModel(SoapService entity){
        SoapServiceModel model = new SoapServiceModel();
        if(entity != null){
            if(null != entity.getId()) {
                model.setId(entity.getId());
            }
            model.setName(entity.getName());
            model.setMetadata(entity.getMetadata());
        }
        return model;
    }
}
