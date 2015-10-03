package com.dragonfly.iscorecard.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Parameter;

import javax.persistence.MappedSuperclass;

/**
 * Created by Arun on 9/4/2015.
 */
@MappedSuperclass
public abstract class Model {
    public static final int ID_LENGTH = 36;
    public static final int ENUM_LENGTH = 256;

    @Id
    @Column(name = "ID", updatable = false)
    @Size(max = ID_LENGTH)
    @GeneratedValue(generator = "UuidOrAssignedGenerator")
    @GenericGenerator(name = "UuidOrAssignedGenerator", strategy = "jpa.UuidOrAssignedGenerator", parameters = { @Parameter(name = "strategy", value = "uuid2") })
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}