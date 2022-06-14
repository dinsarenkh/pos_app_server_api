package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.ExtendedProperty;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ExtendedPropertyRepository extends CrudRepository<ExtendedProperty, Integer> {
    List<ExtendedProperty> findAllByStatus(String status);
    List<ExtendedProperty> findAllByCodeAndStatus(String code, String status);
    Optional<ExtendedProperty> findByKeyAndStatus(String key, String status);

}
