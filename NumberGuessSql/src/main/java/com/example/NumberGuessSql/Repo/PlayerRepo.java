package com.example.NumberGuessSql.Repo;

import com.example.NumberGuessSql.entity.PlayerEntry;
import com.example.NumberGuessSql.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepo extends JpaRepository<PlayerEntry,Long> {
    Optional<PlayerEntry> findByQuestionId(Long questionId);
}
