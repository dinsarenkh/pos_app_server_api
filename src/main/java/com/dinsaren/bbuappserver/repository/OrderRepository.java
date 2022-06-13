package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Category;
import com.dinsaren.bbuappserver.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findAllByStatus(String status);
}
