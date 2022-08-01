package com.dinsaren.bbuappserver.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "pof_post")
@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String imageUrl;
    private int categoryId;
    private String categoryName;
    private int subCategoryId;
    private int brandId;
    private int modelId;
    private int years;
    private int locationId;
    private String condition;// old,new
    private double price;
    private String description;
    private int createdId;
    private String username;
    private Date createdDate;
    private Date updatedDate;
    private int updatedBy;
    private String status;// ACT,DEL,SLD

}
