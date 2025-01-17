package com.edtech.quizz.Repo;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edtech.quizz.Model.Flashcard;

@Repository
public interface FlashcardRepo extends JpaRepository<Flashcard,Integer>{

    List<Flashcard> findAllByTopicTopicId(int topicId);
    
    // @Query("SELECT f FROM Flashcard f WHERE LOWER(f.keyword) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    // List<Flashcard> searchFlashcards(@Param("searchTerm") String searchTerm);

    // // @Query("SELECT DISTINCT f.keyword FROM Flashcard f WHERE LOWER(f.keyword) LIKE LOWER(CONCAT(:prefix, '%'))")
    // // List<String> findKeywordsByPrefix(@Param("prefix") String prefix);

    // @Query("SELECT DISTINCT f.keyword FROM Flashcard f " +
    //    "WHERE LOWER(f.keyword) LIKE LOWER(CONCAT('%', :term, '%')) " +
    //    "ORDER BY LENGTH(f.keyword), f.keyword ASC")
    // List<String> findKeywordsByFlexibleSearch(@Param("term") String term);
    
}
