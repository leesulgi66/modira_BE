package com.example.modiraa.post.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@Builder
@Entity // DB 테이블 역할을 합니다.
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    //카테고리 이름
    @Column(nullable = false)
    private String category;

    //제목
    @Column(nullable = false)
    private String title;

    //주소
    @Column(nullable = false)
    private String address;

    //내용
    @Column(nullable = false)
    private String contents;

    //날짜
    @Column(nullable = false)
    private String date;

    //인원 수
    @Column(nullable = false)
    private int numberofpeople;

    //음식 메뉴
    @Column(nullable = false)
    private String menu;

    //성별
    @Column
    private String gender;

    //나이대
    @Column
    private String age;

}