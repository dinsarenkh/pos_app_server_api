package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(	name = "bbu_booking_floor")
@Data
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "branch_id")
    private int branchId;
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    private String status = Constants.ACTIVE_STATUS;

}
