package com.example.talkenbackend.relation.repository;

import com.example.talkenbackend.relation.domain.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Long> {
    Optional<List<Relation>> findByFromUserId(Long fromUserId);
}
