package com.example.diegobasili.services;

import com.example.diegobasili.enetities.Author;
import com.example.diegobasili.exeptions.NotFoudException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorsService {
    private List<Author> authorsList = new ArrayList<>();

    public List<Author> findAll() {
        return this.authorsList;
    }

    public Author saveAuthor(Author body) {
        Random r = new Random();
        body.setId(r.nextInt(1, 1000));
        this.authorsList.add(body);
        return body;
    }

    public Author findById(int authorId) {
        return authorsList.stream().filter(post -> post.getId() == authorId).findFirst().orElseThrow(() -> new NotFoudException(authorId));
    }

    public Author findByIdAndUpdate(int authorId, Author updateBody) {
        Author found = findById(authorId);
        found.setName(updateBody.getName());
        found.setSurname(updateBody.getSurname());
        found.setEmail(updateBody.getEmail());
        found.setDateofBirth(updateBody.getDateofBirth());
        found.setAvatar(updateBody.getAvatar());
        if (found == null) throw new NotFoudException(authorId);
        return found;
    }

    public void findByIdAndDelete(int authorId) {
        Author found = findById(authorId);
        if (found == null) throw new NotFoudException(authorId);
        this.authorsList.remove(found);
    }
}
