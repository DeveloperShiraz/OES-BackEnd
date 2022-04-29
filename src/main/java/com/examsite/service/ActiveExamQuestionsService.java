package com.examsite.service;

import java.util.List;

import com.examsite.model.ActiveExamQuestionsModel;

public interface ActiveExamQuestionsService {
	public ActiveExamQuestionsModel saveActiveExamQuestions(ActiveExamQuestionsModel activeExamQuestions);
	public ActiveExamQuestionsModel updateActiveExamQuestions(ActiveExamQuestionsModel activeExamQuestions);
	public ActiveExamQuestionsModel getActiveExamQuestionsById(Integer activeExamQuestionsId);
	public List<ActiveExamQuestionsModel> getAllActiveExamQuestions();
	public void deleteActiveExamQuestion(Integer activeExamQuestionsId);
	
}
