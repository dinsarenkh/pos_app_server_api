package com.dinsaren.bbuappserver.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pof_brand")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int subCategoryId;
    private String name;
    private String nameKh;
    private String imageUrl;
    private String status;

}
