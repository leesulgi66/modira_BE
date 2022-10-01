package com.example.modiraa.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.example.modiraa.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static com.example.modiraa.model.QPost.post;

@RequiredArgsConstructor
@Repository
public class PostQueryRepository {
    private final JPAQueryFactory queryFactory;

    public Page<Post> findBySearchKeywordAndAddress(Long lastId, String address, String keyword, Pageable pageable) {
        QueryResults<Post> result = queryFactory.selectFrom(post)
                .where(post.id.lt(lastId).and(post.address.contains(address)))
                .where(post.menu.contains(keyword)
                        .or(post.title.contains(keyword)).or(post.contents.contains(keyword)))
                .join(post.member)
                .join(post.postImage)
                .join(post.chatRoom)
                .fetchJoin()
                .orderBy(post.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(result.getResults(), pageable, result.getTotal());
    }
}
