package com.arbahi.examsmanagement.repository;

import com.arbahi.examsmanagement.entity.PedagogicalElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface PedagogicalElementRepository extends JpaRepository<PedagogicalElement,Integer> {
    @Query(value = "SELECT * FROM pedagogical_element WHERE coordinator_id = :coordinatorId", nativeQuery = true)
    PedagogicalElement findByCoordinatorId(@Param("coordinatorId") Integer coordinatorId);

    Collection<Object> findByType(String type);
}
