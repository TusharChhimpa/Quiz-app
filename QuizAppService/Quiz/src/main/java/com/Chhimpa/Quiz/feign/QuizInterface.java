package com.Chhimpa.Quiz.feign;

import com.Chhimpa.Quiz.Model.QuestionWrapper;
import com.Chhimpa.Quiz.Model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION")
public interface QuizInterface  {
    @PostMapping("questions/genrate")
    public ResponseEntity<List<Integer>> genrate(@RequestParam String category, @RequestParam Integer id);

    @PostMapping("questions/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> id);

    @PostMapping("questions/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> response);

}
