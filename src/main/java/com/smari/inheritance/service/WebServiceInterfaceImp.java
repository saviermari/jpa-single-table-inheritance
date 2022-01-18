package com.smari.inheritance.service;

import com.smari.inheritance.dao.WebServiceRepository;
import com.smari.inheritance.dto.RestServiceModel;
import com.smari.inheritance.dto.SoapServiceModel;
import com.smari.inheritance.entity.RestService;
import com.smari.inheritance.entity.SoapService;
import com.smari.inheritance.dto.WebServiceModel;
import com.smari.inheritance.entity.WebService;
import com.smari.inheritance.mapper.WebServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WebServiceInterfaceImp implements WebServiceInterface{
    @Autowired
    WebServiceRepository repository;

    @Autowired
    WebServiceMapper mapper;

    @Override
    public WebServiceModel createWebService(WebServiceModel model) {
        if(model instanceof RestServiceModel){
           return mapper.convertEntityToModel(repository.save(mapper.convertModelToEntity((RestServiceModel)model)));
        }else{
            return mapper.convertEntityToModel(repository.save(mapper.convertModelToEntity((SoapServiceModel)model)));
        }
    }

    @Override
    public WebServiceModel updateWebService(WebServiceModel model) {
        if(model instanceof RestServiceModel){
            return mapper.convertEntityToModel(repository.save(mapper.convertModelToEntity((RestServiceModel)model)));
        }else{
            return mapper.convertEntityToModel(repository.save(mapper.convertModelToEntity((SoapServiceModel)model)));
        }
    }

    @Override
    public void deleteWebService(Long id) {
        repository.deleteById(id);
    }

    @Override
    public WebServiceModel getWebService(Long id) {
        Optional<WebService>  optional = repository.findById(id);
        if(optional.isPresent()){
            if(optional.get() instanceof RestService){
                return mapper.convertEntityToModel((RestService) optional.get());
            }
            return mapper.convertEntityToModel((SoapService) optional.get());
        }
        return null;
    }
    @Override
    public List<WebServiceModel> getAllProducts() {
        List<WebService> products = repository.findAll();
        List<WebServiceModel>  productModels = products.stream().map(mapper::convertEntityToModel).collect(Collectors.toList());
        return productModels;
    }
}
