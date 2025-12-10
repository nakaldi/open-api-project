package com.example.open_api_project.module.post.repository;

import com.example.open_api_project.module.post.dto.PostResponseDto;
import com.example.open_api_project.module.post.entity.Post;

import java.util.List;
import java.util.Optional;

/**
 * 게시글을 위한 리포지토리 인터페이스
 */
public interface PostRepository {
    /**
     * 무한 스크롤을 위한 게시글 목록 조회
     *
     * @param limit  가져올 게시글 수
     * @param offset 시작 위치
     * @return 게시글 목록
     */
    List<PostResponseDto> findPosts(int limit, long offset);

    Optional<PostResponseDto> findPostResponseDto(Long id);

    /**
     * 게시글 저장
     *
     * @param post 저장할 게시글 정보
     */
    void save(Post post);
}
