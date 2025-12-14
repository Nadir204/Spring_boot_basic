package com.example.NumberGuessSql.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Table(name="questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customId;
    //later update
    private String Quu;
    //up done

    @ElementCollection
    private List<Integer> options;
    private Integer correctAns;



    //getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomId() {
        return customId;
    }

    public void setCustomId(Long customId) {
        this.customId = customId;
    }

    public String getQuu() {
        return Quu;
    }

    public void setQuu(String quu) {
        Quu = quu;
    }

    public List<Integer> getOptions() {
        return options;
    }

    public void setOptions(List<Integer> options) {
        this.options = options;
    }

    public Integer getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(Integer correctAns) {
        this.correctAns = correctAns;
    }
}
