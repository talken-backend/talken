package com.example.talkenbackend.relation.repository;

import com.example.talkenbackend.relation.domain.Relation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.talkenbackend.relation.domain.QRelation.relation;

@RequiredArgsConstructor
@Repository
public class RelationQueryDslRepository {
    private final JPAQueryFactory queryFactory;

    public void deleteByFromUserIdAndToUserId(Long fromUserId, Long toUserId) {
        queryFactory
                .delete(relation)
                .where(relation.fromUserId.eq(fromUserId)
                        .and(relation.toUserId.eq(toUserId))).execute();
        queryFactory
                .delete(relation)
                .where(relation.fromUserId.eq(toUserId)
                        .and(relation.toUserId.eq(fromUserId))).execute();
    }


    public Relation findByFromUserIdAndToUserId(Long fromUserId, Long toUserId) {
        return queryFactory.selectFrom(relation)
                .where(relation.fromUserId.eq(fromUserId).and(
                        relation.toUserId.eq(toUserId))).fetchOne();

    }
}
