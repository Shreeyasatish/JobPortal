package com.shravani.joblisting.repository;

import com.shravani.joblisting.models.Post;

import java.util.List;

public interface SearchRepository {
  List<Post> findByText(String text);
}
