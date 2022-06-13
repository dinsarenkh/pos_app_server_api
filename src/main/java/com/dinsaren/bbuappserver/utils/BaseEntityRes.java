package com.dinsaren.bbuappserver.utils;

import com.dinsaren.bbuappserver.constants.Constants;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntityRes{
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt = new Date();
    private String createBy = Constants.SYSTEM;
    private Date updateAt;
    private String updateBy;

}
