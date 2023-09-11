package com.example.talkenbackend.feedback.repository;

import com.example.talkenbackend.feedback.domain.Feedback;
import com.example.talkenbackend.feedback.domain.QFeedback;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.talkenbackend.feedback.domain.QFeedback.feedback;

@RequiredArgsConstructor
@Repository
public class FeedbackQueryDslRepository {
    private final JPAQueryFactory queryFactory;
//    public List<Feedback> searchBy(String region) {
//        return queryFactory
//                .selectFrom(feedback)
////                .where(feedback.region.eq(region))
//                .fetch();
//    }
}
