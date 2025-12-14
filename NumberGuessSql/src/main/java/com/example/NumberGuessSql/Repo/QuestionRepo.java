package com.example.NumberGuessSql.Repo;

import com.example.NumberGuessSql.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepo extends JpaRepository<Question,Long> {


    Optional<Question> findByCustomId(Long customId);
}
