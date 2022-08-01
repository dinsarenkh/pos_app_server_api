package com.dinsaren.bbuappserver.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pof_category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nameKh;
    private String imageUrl;
    private String status;
}
