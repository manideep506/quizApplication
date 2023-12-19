package com.example.quizApplication.controller;


import com.example.quizApplication.model.Question;
import com.example.quizApplication.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    // To Display all the Question : http://localhost:8080/question/allQuestions
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    // Display only Category Column Question : http://localhost:8080/question/category/categoryName
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    // Display only ID Column Question : http://localhost:8080/question/id/idNum
    @GetMapping("id/{id}")
    public Optional<Question> getQuestionsById(@PathVariable Integer id){
        return questionService.getQuestionsById(id);
    }

    // Adding the new Questions to DB : http://localhost:8080/question/add
    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    // Deleting the Questions from DB : http://localhost:8080/question/delete
    @DeleteMapping("delete")
    public String deleteQuestion(@RequestBody Question question){
        return questionService.deleteQuestion(question);
    }
}