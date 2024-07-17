package com.tayyaba.quizzapp.service;

import com.tayyaba.quizzapp.dao.QuestionDao;
import com.tayyaba.quizzapp.dao.QuizDao;
import com.tayyaba.quizzapp.model.Question;
import com.tayyaba.quizzapp.model.QuestionWrapper;
import com.tayyaba.quizzapp.model.Quiz;
import com.tayyaba.quizzapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions= questionDao.findQuestionsByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Quiz created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
       Optional<Quiz> quiz= quizDao.findById(id);
       //fetch all questions
       List<Question> questionsFromDB = quiz.get().getQuestions();
       //now we convert each question into question wrapper
        List<QuestionWrapper> questionsForUser= new ArrayList<>();
        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getCategory(),q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responses){
          if(response.getResponse().equals(questions.get(i).getRight_answer())){
              right++;}
          i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
