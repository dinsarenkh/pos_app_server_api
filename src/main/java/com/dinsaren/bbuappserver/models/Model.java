package com.dinsaren.bbuappserver.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pof_model")
@Data
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int brandId;
    private String name;
    private String nameKh;
    private String imageUrl;
    private String status;
}
