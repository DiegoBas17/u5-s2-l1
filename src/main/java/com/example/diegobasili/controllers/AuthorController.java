package com.example.diegobasili.controllers;

import com.example.diegobasili.enetities.Author;
import com.example.diegobasili.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorsService authorsService;

    @GetMapping
    private List<Author> getAllAuthors() {
        return authorsService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Author createAuthor(@RequestBody Author body) {
        return authorsService.saveAuthor(body);
    }

    @GetMapping("/{authorId}")
    private Author getAuthorById(@PathVariable int authorId) {
        return authorsService.findById(authorId);
    }

    @PutMapping("/{authorId}")
    private Author findAuthorByIdAndUpdate(@PathVariable int authorId, @RequestBody Author body) {
        return authorsService.findByIdAndUpdate(authorId, body);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findAuthorByIdAndDelete(@PathVariable int authorId) {
        authorsService.findByIdAndDelete(authorId);
    }
}
