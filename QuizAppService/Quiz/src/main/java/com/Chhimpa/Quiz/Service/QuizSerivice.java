package com.Chhimpa.Quiz.Service;


import com.Chhimpa.Quiz.DAO.QuizDao;
import com.Chhimpa.Quiz.Model.QuestionWrapper;
import com.Chhimpa.Quiz.Model.Quiz;
import com.Chhimpa.Quiz.Model.Response;
import com.Chhimpa.Quiz.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizSerivice {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> create(String category,int numQ,String title)
    {
      List<Integer> l=quizInterface.genrate(category,numQ).getBody();
        Quiz q=new Quiz();
        q.setTitle(title);
        q.setQuestionsId(l);
        quizDao.save(q);
        return  new ResponseEntity<>("Created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestion(Integer id) {
       Optional<Quiz> q= quizDao.findById(id);
       List<Integer> a=q.get().getQuestionsId();

      List<QuestionWrapper> qw= quizInterface.getQuestions(a).getBody();
//       for(Question u:l)
//       {
//           QuestionWrapper p=new QuestionWrapper(u.getId(),u.getQuestionTitle(),u.getOption1(),u.getOption2(),u.getOption3(),u.getOption4());
//           qw.add(p);
//       }
       return new ResponseEntity<>(qw,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calResult(Integer id, List<Response> res) {
        Integer l=quizInterface.getScore(res).getBody();
//        Optional<Quiz> q=quizDao.findById(id);
//     //   List<Question> p=q.get().getQuestions();
//        int right=0;
//        int i=0;
//
//        for(Response r:res)
//        {
//          //  if(r.getResponse().equals(p.get(i).getRightAnswer()))
//                right++;
//            i++;
//        }
        return new ResponseEntity<>(l,HttpStatus.OK);
    }
}
