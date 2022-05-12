package com.example.t3hdoan.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    @ManyToMany(mappedBy = "roleEntitySet")
    private Set<UserEntity> userEntitySet = new HashSet<>();

    public void setName(String name) {
        this.name = name;
    }
}
