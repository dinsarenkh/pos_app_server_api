package com.dinsaren.bbuappserver.repository;

import com.dinsaren.bbuappserver.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findAllByStatus(String status);
}
