package com.tayyaba.quizzapp.dao;

import com.tayyaba.quizzapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//jparepository takes two inputs, table name and pk type
//repository layer interacts with db
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer > {

    //data access objects maps data onto database


    List<Question> findByCategory(String category);

    //native queries are an alternative to sql queries
    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findQuestionsByCategory(String category, int numQ);
}
