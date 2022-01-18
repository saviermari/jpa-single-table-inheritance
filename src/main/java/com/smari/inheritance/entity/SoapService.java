package com.smari.inheritance.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="SOAP")
public class SoapService extends WebService {
}