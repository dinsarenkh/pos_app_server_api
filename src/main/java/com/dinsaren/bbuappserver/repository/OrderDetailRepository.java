package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.OrderDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer> {
    List<OrderDetail> findAllByStatus(String status);
    Integer countByOrderIdAndStatus(Integer orderId, String status);
    List<OrderDetail> findAllByOrderIdAndStatus(Integer orderId, String status);
}
