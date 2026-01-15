package com.example.quiz.service;

import com.example.quiz.dto.QuizResultResponse;
import com.example.quiz.dto.QuizSubmissionRequest;
import com.example.quiz.entity.Question;
import com.example.quiz.entity.Quiz;
import com.example.quiz.exception.NoQuizFoundException;
import com.example.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuiz(Long id) {
        Optional<Quiz> quizOptional = quizRepository.findById(id);
        if(quizOptional.isEmpty()){
            throw new NoQuizFoundException("quiz not found");
        }
        Quiz quiz = quizOptional.get();
        return quiz;
    }

    @Override
    public QuizResultResponse evaluate(Long id, QuizSubmissionRequest request) {
        Optional<Quiz> quizOptional = quizRepository.findById(id);
        if(quizOptional.isEmpty()){
            throw new NoQuizFoundException("quiz not found");
        }
        Quiz quiz = quizOptional.get();
        int correct = 0;


        for (Question q : quiz.getQuestions()) {
            String submitted = request.getAnswers().get(q.getId());
            if (submitted == null) continue;


            switch (q.getQuestionType()) {
                case MCQ -> {
                    correct += q.getOptions().stream()
                            .anyMatch(o -> o.isCorrect() && o.getId().toString().equals(submitted)) ? 1 : 0;
                }
                case TRUE_FALSE -> {
                    boolean correctVal = q.getOptions().get(0).isCorrect();
                    if (Boolean.toString(correctVal).equalsIgnoreCase(submitted)) correct++;
                }
                case TEXT -> {
                    if (q.getCorrectAnswer().equalsIgnoreCase(submitted.trim())) correct++;
                }
            }
        }
        return new QuizResultResponse(quiz.getQuestions().size(), correct);

    }
}
