package com.example.Question.DAO;

import com.example.Question.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dao extends JpaRepository<Question,Integer> {

   List<Question> findByCategory(String category);

   @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
   public List<Question> findByCategoryRandom(String category, int numQ);
}
