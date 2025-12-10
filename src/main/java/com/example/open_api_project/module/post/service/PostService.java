package com.example.open_api_project.module.post.service;

import com.example.open_api_project.module.post.dto.PostCreateRequestDto;
import com.example.open_api_project.module.post.dto.PostResponseDto;

import java.util.List;

public interface PostService {

    List<PostResponseDto> getPosts(int limit, long offset);

    PostResponseDto createPost(PostCreateRequestDto requestDto, Long id);
}
