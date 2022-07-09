package com.dinsaren.bbuappserver.models;

import com.dinsaren.bbuappserver.constants.Constants;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(	name = "bbu_booking_room")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    private String status = Constants.ACTIVE_STATUS;
    @Column(name = "floor_id")
    private int floorId;
    @Column(name = "room_type_id")
    private int roomTypeId;
    private Double price;
    private Double discount;

}
