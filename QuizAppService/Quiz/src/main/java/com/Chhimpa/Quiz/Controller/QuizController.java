package com.Chhimpa.Quiz.Controller;

import com.Chhimpa.Quiz.Model.QuestionWrapper;
import com.Chhimpa.Quiz.Model.QuizDTO;
import com.Chhimpa.Quiz.Model.Response;
import com.Chhimpa.Quiz.Service.QuizSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizSerivice s;
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody QuizDTO d)
    {
return s.create(d.getCategoryName(),d.getNumQuestions(),d.getTitle());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> get(@PathVariable int id)
    {
        return  s.getQuestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submit(@PathVariable Integer id, @RequestBody List<Response> res)
    {
        return s.calResult(id,res);
    }
}
