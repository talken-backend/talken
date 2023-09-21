package com.example.talkenbackend.relation.service;

import com.example.talkenbackend.relation.domain.Relation;
import com.example.talkenbackend.relation.repository.RelationQueryDslRepository;
import com.example.talkenbackend.relation.repository.RelationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RelationService {
    private final RelationRepository relationRepository;
    private final RelationQueryDslRepository relationQueryDslRepository;

    public void unSetRelation(Long fromUserId, Long toUserId) {

        relationQueryDslRepository.deleteByFromUserIdAndToUserId(fromUserId, toUserId);
        relationQueryDslRepository.deleteByFromUserIdAndToUserId(toUserId, fromUserId);

    }

    public void setRelation(Long fromUserId, Long toUserId) {
        Relation saved = relationQueryDslRepository.findByFromUserIdAndToUserId(fromUserId, toUserId);
        if (saved!=null){ // 이미 세팅 된 관계
            return;
        }

        // 양방향 저장
        Relation relation = Relation.builder()
                .fromUserId(fromUserId)
                .toUserId(toUserId)
                .build();
        Relation relation2 = Relation.builder()
                .fromUserId(toUserId)
                .toUserId(fromUserId)
                .build();
        relationRepository.save(relation);
        relationRepository.save(relation2);
    }
}
