package com.ecycle.book.freespringwebservice.service;

import com.ecycle.book.freespringwebservice.web.domain.posts.Posts;
import com.ecycle.book.freespringwebservice.web.domain.posts.PostsRepository;
import com.ecycle.book.freespringwebservice.web.dto.PostsListResponseDto;
import com.ecycle.book.freespringwebservice.web.dto.PostsResponseDto;
import com.ecycle.book.freespringwebservice.web.dto.PostsSaveRequestDto;
import com.ecycle.book.freespringwebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;


    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;

    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    public void delete (Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        postsRepository.delete(posts);
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.id = " + id));
        return new PostsResponseDto(entity);

    }
}
