package com.examsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.examsite.model.ActiveExamQuestionsModel;
import com.examsite.service.ActiveExamQuestionsService;

@CrossOrigin
@RestController
public class ActiveExamQuestionsController {
	
	@Autowired
	private ActiveExamQuestionsService activeExamQuestionsService;
	
	@GetMapping("/getAllActiveExamQuestions")
	public List<ActiveExamQuestionsModel> getAllActiveExamQuestions(){
		return activeExamQuestionsService.getAllActiveExamQuestions();
	}
	
	@PostMapping
	public ActiveExamQuestionsModel saveActiveExamQuestions(@RequestBody ActiveExamQuestionsModel activeExamQuestions){
		return activeExamQuestionsService.saveActiveExamQuestions(activeExamQuestions);
	}
	
	public ActiveExamQuestionsModel updateActiveExamQuestions(@RequestBody ActiveExamQuestionsModel activeExamQuestions){
		return activeExamQuestionsService.updateActiveExamQuestions(activeExamQuestions);
	}
	
	public void deleteActiveExamQuestion(@RequestParam Integer activeExamQuestionsId){
		activeExamQuestionsService.deleteActiveExamQuestion(activeExamQuestionsId);
	}
}
