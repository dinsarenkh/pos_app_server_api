package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(	name = "bbu_pos_category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    private String status = Constants.ACTIVE_STATUS;
    @Column(name = "parent_id")
    private Integer parentId;

}
