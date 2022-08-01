package com.dinsaren.bbuappserver.services;

import com.dinsaren.bbuappserver.constants.Constants;
import com.dinsaren.bbuappserver.models.Post;
import com.dinsaren.bbuappserver.repository.CategoryRepository;
import com.dinsaren.bbuappserver.repository.PostRepository;
import com.dinsaren.bbuappserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Post> findAll(){
        var listAll =  postRepository.findAllByStatus(Constants.ACTIVE_STATUS);
        List<Post> list =new ArrayList<>();
        listAll.forEach(p->{
            var post = new Post();
            post = p;
            var user = userRepository.findById(Long.valueOf(p.getCreatedId()));
            if(user.isPresent()){
                post.setUsername(user.get().getUsername());
            }

            var category =categoryRepository.findById(p.getCategoryId());
            if(category.isPresent()){
                post.setCategoryName(category.get().getName());
            }
            list.add(post);
        });
        return list;
    }
}
