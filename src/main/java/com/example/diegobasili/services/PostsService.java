package com.example.diegobasili.services;

import com.example.diegobasili.enetities.Post;
import com.example.diegobasili.exeptions.NotFoudException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PostsService {
    private List<Post> postsList = new ArrayList<>();

    public List<Post> findAll() {
        return this.postsList;
    }

    public Post savePost(Post body) {
        Random r = new Random();
        body.setId(r.nextInt(1, 1000));
        this.postsList.add(body);
        return body;
    }

    public Post findById(int postId) {
        return postsList.stream().filter(post -> post.getId() == postId).findFirst().orElseThrow(() -> new NotFoudException(postId));
    }

    public Post findByIdAndUpdate(int postId, Post updateBody) {
        Post found = findById(postId);
        found.setCategory(updateBody.getCategory());
        found.setTitle(updateBody.getTitle());
        found.setCover(updateBody.getCover());
        found.setContent(updateBody.getContent());
        found.setTimeForRead(updateBody.getTimeForRead());
        if (found == null) throw new NotFoudException(postId);
        return found;
    }

    public void findByIdAndDelete(int postId) {
        Post found = findById(postId);
        if (found == null) throw new NotFoudException(postId);
        this.postsList.remove(found);
    }
}
