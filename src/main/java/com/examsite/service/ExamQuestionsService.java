package com.examsite.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.examsite.dto.ExamQuestionsByEmailIdDTO;
import com.examsite.dto.RandomExamQuestionsDTO;
import com.examsite.model.ExamQuestionsModel;

public interface ExamQuestionsService {
	public ExamQuestionsModel saveExamQuestions(ExamQuestionsModel examQuestions);
	public ExamQuestionsModel updateExamQuestions(ExamQuestionsModel examQuestions);
	public ExamQuestionsModel getExamQuestionsById(Integer examQuestionsById);
	public List<ExamQuestionsModel> getAllExamQuestions();
	public void deleteExamQuestions(Integer examQuestionsById);
	public List<RandomExamQuestionsDTO> getRandomExamQuestions();
	
	public String setupExamConfiguration(String emailId);
	public void saveUserAnswer(String userAnswer, Integer questionId, String emailId);
	public ExamQuestionsByEmailIdDTO getExamQuestionsByEmailId(String emailId, Pageable pageRequest);
}
