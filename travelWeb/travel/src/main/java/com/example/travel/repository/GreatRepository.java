package com.example.travel.repository;

import com.example.travel.domain.Great;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GreatRepository extends JpaRepository<Great,Integer> {
    List<Great> findByAidAndUid(int aid, int uid);
}
