package com.tayyaba.quizzapp.controller;

import com.tayyaba.quizzapp.model.Question;
import com.tayyaba.quizzapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    //controller receives requests from clients and sends it to service

    //autowired connects two beans
    @Autowired
    QuestionService questionService;

    //defines endpoint
    @RequestMapping("allQuestions")
    //we call another bean here in parameter without making an object, this is called field mapping
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    //path variable tkes variable from url
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
       return questionService.getQuestionsByCategory(category);
    }

   //requestbody specifies this data is gonna go in the request body
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

}
