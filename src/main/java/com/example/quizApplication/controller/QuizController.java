package com.example.quizApplication.controller;


import com.example.quizApplication.model.QuestionWrapper;
import com.example.quizApplication.model.Response;
import com.example.quizApplication.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    // create=ing the Quiz : http://localhost:8080/quiz/create?category=java&numQ=3@title=JQuiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }

    // get data from created Quiz : http://localhost:8080/quiz/get/1
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    //Submit the response: http://localhost:8080/quiz/submit/1
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }
}