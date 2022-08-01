package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Slide;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlideRepository extends CrudRepository<Slide, Integer> {
    List<Slide> findAllByStatus(String status);
    Slide findByIdAndStatus(Integer id, String status);

}
