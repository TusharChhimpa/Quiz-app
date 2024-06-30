package com.example.Question.Service;

import com.example.Question.DAO.Dao;
import com.example.Question.Model.Question;
import com.example.Question.Model.QuestionWrapper;
import com.example.Question.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceQuestion {

    @Autowired
    Dao dao;
            public ResponseEntity<List<Question>> getAllQuestions()
            {
                return new ResponseEntity<>(dao.findAll(),HttpStatus.OK);
            }

    public ResponseEntity<String> add(List<Question> q) {
        dao.saveAll(q);
                return  new ResponseEntity<>("Created",HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> searchByCategory(String category) {
             return new ResponseEntity<>(dao.findByCategory(category), HttpStatus.OK);
    }

    public ResponseEntity<List<Integer>> genrate(String category,int numQ)
    {
        System.out.println(category+"-----------"+numQ);
        List<Question> l=dao.findByCategoryRandom(category,numQ);
        List<Integer> id=new ArrayList<>();
        for(Question i:l)
        {System.out.println("---------"+i.getId());
            id.add(i.getId());
        }


        return  new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestions(List<Integer> id) {
                List<Question> q=new ArrayList<>();
                for(int i=0;i<id.size();i++)
                {
                    System.out.println(id.get(i));
                    q.add(dao.findById(id.get(i)).get());
                }
                List<QuestionWrapper> r=new ArrayList<>();
                for(Question t:q)
                {

                    QuestionWrapper o=new QuestionWrapper(t.getId(),t.getQuestionTitle(),t.getOption1(),t.getOption2(),t.getOption3(),t.getOption4());
                    r.add(o);
                }
                return  new ResponseEntity<>(r,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calResult( List<Response> res) {

        int right=0;


        for(Response r:res)
        {
            Question q=dao.findById(r.getId()).get();
            if(r.getResponse().equals(q.getRightAnswer()))
                right++;
            System.out.println(right);

        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
