package com.examsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examsite.dto.ExamQuestionsByEmailIdDTO;
import com.examsite.dto.RandomExamQuestionsDTO;
import com.examsite.model.ExamHistoryModel;
import com.examsite.model.ExamQuestionsModel;
import com.examsite.service.ExamQuestionsService;

@CrossOrigin
@RestController
public class ExamQuestionsController {
	
	@Autowired
	private ExamQuestionsService examQuestionsService;
	
	
	@GetMapping("/getAllExamQuestions")
	public List<ExamQuestionsModel> getAllExamQuestions(){
		return examQuestionsService.getAllExamQuestions();
	}
	
	@PostMapping("/saveExamQuestions")
	public ExamQuestionsModel saveExamQuestions(@RequestBody ExamQuestionsModel examQuestions){
		return examQuestionsService.saveExamQuestions(examQuestions);
	}
	
	@PutMapping("/updateExamQuestions")
	public ExamQuestionsModel updateExamQuestions(@RequestBody ExamQuestionsModel examQuestions){
		return examQuestionsService.updateExamQuestions(examQuestions);
	}
	
	@DeleteMapping("/deleteExamQuestion")
	public void deleteExamQuestions(@RequestBody Integer examQuestionsById){
		examQuestionsService.deleteExamQuestions(examQuestionsById);
	}
	
	//Get 5 Random Questions from exam_questions:
	@GetMapping("/getRandomExamQuestions")
	public List<RandomExamQuestionsDTO> getRandomExamQuestions(){
		return examQuestionsService.getRandomExamQuestions();
	}
	
	@GetMapping("/setupExam")
	public String setupExam(@RequestParam String emailId){
		return examQuestionsService.setupExamConfiguration(emailId);
	}
	
	@GetMapping("/saveUserAnswer")
	public void saveUserAnswer(@RequestParam String emailId,@RequestParam String userAnswer, @RequestParam Integer questionId){
		examQuestionsService.saveUserAnswer(userAnswer, questionId, emailId);
	}
	
	@GetMapping("/getExamQuestionsByEmailId")
	public ExamQuestionsByEmailIdDTO getExamQuestionsByEmailId(@RequestParam String emailId, @RequestParam Integer page){
		return examQuestionsService.getExamQuestionsByEmailId(emailId, PageRequest.of(page,1));
	}
	
	@GetMapping("/validateExam")
	public ExamHistoryModel validateExam(@RequestParam String emailId) {
		return examQuestionsService.validateExam(emailId);
	}
}
