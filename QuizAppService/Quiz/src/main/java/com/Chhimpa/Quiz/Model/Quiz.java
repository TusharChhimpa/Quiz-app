package com.Chhimpa.Quiz.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer id;
    public String title;
    @ElementCollection
    public List<Integer> questionsId;
}
