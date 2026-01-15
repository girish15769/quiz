package com.example.quiz.service;

import com.example.quiz.entity.Quiz;
import org.springframework.stereotype.Service;

@Service
public interface QuizService {

    Quiz createQuiz(Quiz quiz);
    Quiz getQuiz(Long id);

}
