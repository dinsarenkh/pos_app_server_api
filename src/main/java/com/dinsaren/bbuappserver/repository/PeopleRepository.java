package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.People;
import com.dinsaren.bbuappserver.models.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Integer> {
    List<People> findAllByStatus(String status);
    List<People> findAllByTypeAndStatus(String type, String status);

}
