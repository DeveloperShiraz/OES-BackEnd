package com.examsite.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.examsite.model.ExamHistoryModel;

public interface ExamHistoryService {
	public ExamHistoryModel saveExamHistory(ExamHistoryModel examHistory);
	public ExamHistoryModel updateExamHistory(ExamHistoryModel examHistory);
	public ExamHistoryModel getExamHistoryById(Integer examHistoryById);
	public List<ExamHistoryModel> getAllExamHistory();
	public void deleteExamHistory(Integer examHistoryById);
	
	
}
