package com.example.Question.Controller;

import com.example.Question.Model.Question;
import com.example.Question.Model.QuestionWrapper;
import com.example.Question.Model.Response;
import com.example.Question.Service.ServiceQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    ServiceQuestion s;

    @Autowired
    Environment environment;

    @RequestMapping("/allquestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        System.out.println(environment.getProperty("Local.server.port"));
        return s.getAllQuestions();
    }

    @PostMapping("/addquestion")
    public ResponseEntity<String> addQuestion(@RequestBody List<Question> q)
    {
      return s.add(q);
    }

    @RequestMapping("/questionCat/{category}")
    public  ResponseEntity<List<Question>> getByCategory(@PathVariable String category)
    {

       return s.searchByCategory(category);

    }
    @PostMapping("/genrate")
    public ResponseEntity<List<Integer>> genrate(@RequestParam String category,@RequestParam Integer id)
    {
        System.out.println("CDR----"+category+"body---"+id);
        return s.genrate(category,id);
    }
    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> id)
    { System.out.println(environment.getProperty("local.server.port"));

        return s.getQuestions(id);
    }
    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> response)
    {
return s.calResult(response);
    }

}
