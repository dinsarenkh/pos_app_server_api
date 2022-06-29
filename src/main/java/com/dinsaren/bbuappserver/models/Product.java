package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(	name = "bbu_pos_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "category_id")
    private String categoryId;
    private String status = Constants.ACTIVE_STATUS;
    private double price;
    private double qty;
    private double discount;

}
