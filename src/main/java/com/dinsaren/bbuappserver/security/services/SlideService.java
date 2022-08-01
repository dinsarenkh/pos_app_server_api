package com.dinsaren.bbuappserver.security.services;

import com.dinsaren.bbuappserver.models.Slide;

import java.util.List;

public interface SlideService {
    List<Slide> findAllSlide();
    Slide findById(Integer id);
    void save(Slide req);
    void update(Slide req);
    void delete(Slide req);
}
