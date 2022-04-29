package com.examsite.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.examsite.model.ExamHistoryModel;
import com.examsite.service.ExamHistoryService;

@CrossOrigin
@RestController
public class ExamHistoryController {
	
	@Autowired
	private ExamHistoryService examHistoryService;
	
	@GetMapping("/getAllExamHistory")
	public List<ExamHistoryModel> getAllExamHistory(){
		return examHistoryService.getAllExamHistory();
	}
	
	@PostMapping("/saveExamHistor")
	public ExamHistoryModel saveExamHistory(@RequestBody ExamHistoryModel examHistory){
		return examHistoryService.saveExamHistory(examHistory);
	}
	
	@PutMapping("/updateExamHistory")
	public ExamHistoryModel updateExamHistory(@RequestBody ExamHistoryModel examHistory){
		return examHistoryService.updateExamHistory(examHistory);
	}
	
	@DeleteMapping("/deleteExamHistory")
	public void deleteExamHistory(@RequestBody Integer examHistoryById){
		examHistoryService.deleteExamHistory(examHistoryById);
	}
}
