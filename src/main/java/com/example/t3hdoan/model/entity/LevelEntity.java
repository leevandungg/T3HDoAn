package com.example.t3hdoan.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "level")
public class LevelEntity extends BaseEntity{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
