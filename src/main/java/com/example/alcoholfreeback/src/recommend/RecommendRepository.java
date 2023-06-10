package com.example.alcoholfreeback.src.recommend;

import com.example.alcoholfreeback.src.recommend.entity.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendRepository extends JpaRepository<Recommend, Long> {

}
