package com.example.open_api_project.module.post.service;

import com.example.open_api_project.common.exception.ApiException;
import com.example.open_api_project.common.exception.ErrorCode;
import com.example.open_api_project.module.post.dto.PostCreateRequestDto;
import com.example.open_api_project.module.post.dto.PostResponseDto;
import com.example.open_api_project.module.post.entity.Post;
import com.example.open_api_project.module.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    @Override
    public List<PostResponseDto> getPosts(int limit, long offset) {
        return postRepository.findPosts(limit, offset);
    }

    @Transactional
    @Override
    public PostResponseDto createPost(PostCreateRequestDto requestDto, Long id) {
        Post post = Post.builder()
                .content(requestDto.getContent())
                .memberId(id)
                .build();
        postRepository.save(post);
        return postRepository.findPostResponseDto(post.getId())
                .orElseThrow(() -> new ApiException(ErrorCode.POST_NOT_FOUND));
    }
}