package com.dinsaren.bbuappserver.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pof_sub_category")
@Data
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int categoryId;
    private String name;
    private String nameKh;
    private String imageUrl;
    private String status;
}
