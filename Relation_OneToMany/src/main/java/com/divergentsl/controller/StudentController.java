package com.divergentsl.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divergentsl.entity.Answer;
import com.divergentsl.entity.Question;
import com.divergentsl.repo.AnswerRepo;
import com.divergentsl.repo.QuestionRepo;

@RestController("/")
public class StudentController {
 
	@Autowired
	QuestionRepo queRepo;

	@Autowired
	AnswerRepo ansRepo;
	
  /*  @GetMapping("/adduni")
	public String services() {
    	
    	Question question=new Question();
		question.setId(1);
		question.setQuestion("WHAT IS JAVA");
    	
		Answer answer=new Answer();
		answer.setAid(111);
		answer.setAnswer("JAVA IS A PROGRAMMING LANGUAGE");
		answer.setQuestion(question);
		
		Answer answer2=new Answer();
		answer2.setAid(222);
		answer2.setAnswer("IT'S A SIMPLE LANGUAGE");
		answer2.setQuestion(question);
		
		
		  List<Answer> listAnswer=new ArrayList<>();
		  listAnswer.add(answer);
		  listAnswer.add(answer2);
		question.setAnswer(listAnswer);
		  
		queRepo.save(question);
    	 
    	return "Sucess";		
	} 
    */
	
	 @GetMapping("/addbi")
	 public String service() {
	    	
	    	Question question=new Question();
			question.setId(1);
			question.setQuestion("WHAT IS JAVA");
	    	
			Answer answer=new Answer();
			answer.setAid(111);
			answer.setAnswer("JAVA IS A PROGRAMMING LANGUAGE");
		    List<Answer> listAnswer=new ArrayList<>();
			listAnswer.add(answer);
			question.setAnswer(listAnswer);
			answer.setQuestion(question);
		    ansRepo.save(answer);
			
			Answer answer2=new Answer();
			answer2.setAid(222);
			answer2.setAnswer("IT'S A SIMPLE LANGUAGE");
			List<Answer> listAnswer2=new ArrayList<>();
			listAnswer.add(answer2);
			question.setAnswer(listAnswer2);
			answer2.setQuestion(question);
			ansRepo.save(answer2);
			
			  
	    	 
	    	return "Sucess";		
		} 
	
    @GetMapping("/deleteuni")
	public String deleteu() {
       return "null";
    }


 /*   @GetMapping("/addbi")
	public String service() {
    	Student std = new Student();
	    std.setId(2);
	    std.setName("aayush");
	    	Enrollment enroll = new Enrollment();
			enroll.setEnroll(1111);
			enroll.setCollegename("prestige");
		std.setEnrollment(enroll);
		enroll.setStd(std);
		enrollRepo.save(enroll);
		return "sucess";
    }
	*/

	
	@GetMapping("/reads")
	public List<Question> reads()
	{
		List<Question> question= queRepo.findAll();
		return question;
	}
	
	@GetMapping("/reade")
	public List<Answer> reade()
	{
		List<Answer> answers=ansRepo.findAll();
		return answers;
	}
}