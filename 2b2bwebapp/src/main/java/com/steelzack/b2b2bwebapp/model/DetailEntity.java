package com.steelzack.b2b2bwebapp.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Getter
@Table(name = "detail", catalog = "my_catalog")
public class DetailEntity {

    private Integer id;

    private String name;

    @Transient
    private String city;

}
