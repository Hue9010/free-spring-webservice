package com.ecycle.book.freespringwebservice.web.domain.posts;

import com.ecycle.book.freespringwebservice.web.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스, 기본적으로 카멜케이스 이름을 언더스코어(스네이크 네이밍으로 매칭) **
public class Posts extends BaseTimeEntity {

    @Id //PK 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙을 나타냄 , 지금 상태가 오토인크리먼트 적용 상태
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts( String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
