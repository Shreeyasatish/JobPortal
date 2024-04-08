package com.shravani.joblisting.controller;

import com.shravani.joblisting.repository.PostRepository;
import com.shravani.joblisting.models.Post;
import com.shravani.joblisting.repository.SearchRepository;
import com.shravani.joblisting.repository.SearchRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
    @GetMapping("/allposts")
    public List<Post> getAllPosts(){
        return  repo.findAll();
    }

    @PostMapping("/post")

    public Post addPost(@RequestBody Post post)
    {
        return repo.save(post);
    }

    @GetMapping("/posts/{text}")

    public List<Post> search(@PathVariable String text)
    {
        return srepo.findByText(text);
    }

}
