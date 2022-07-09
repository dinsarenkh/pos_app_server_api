package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(	name = "bbu_booking_branch")
@Data
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    private String status = Constants.ACTIVE_STATUS;

}
