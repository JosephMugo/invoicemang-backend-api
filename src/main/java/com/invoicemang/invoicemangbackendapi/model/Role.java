package com.invoicemang.invoicemangbackendapi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 200)
    private Roles name;

    public Role() {
    }

    public Role(Roles name) {
        this.name = name;
    }
}
