package com.example.modiraa.repository;

import com.example.modiraa.model.MemberRoom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.modiraa.model.QMemberRoom.memberRoom;

@RequiredArgsConstructor
@Repository
public class MemberRoomQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<MemberRoom> findByChatRoomId(Long chatroomId){
        return queryFactory.selectFrom(memberRoom)
                .where(memberRoom.chatRoom.id.eq(chatroomId))
                .join(memberRoom.member)
                .join(memberRoom.chatRoom)
                .fetchJoin()
                .fetch();
    }
}
