package com.ecycle.book.freespringwebservice.web.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//프로젝트 규모가 커질 경우 도메인별로 포젝트를 분리해야하기 때문에 Entity와 Repository는 함께 움직여야 하여 도메인 패키지에서 함께 관리함.
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC ")
    List<Posts> findAllDesc();
}
