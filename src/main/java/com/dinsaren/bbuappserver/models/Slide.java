package com.dinsaren.bbuappserver.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pof_slide")
@Data
public class Slide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imageUrl;
    private Integer slidOrder;
    private String status;

}
