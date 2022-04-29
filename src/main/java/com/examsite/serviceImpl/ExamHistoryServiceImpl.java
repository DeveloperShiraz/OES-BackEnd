package com.examsite.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examsite.model.ExamHistoryModel;
import com.examsite.repo.ExamHistoryRepo;
import com.examsite.service.ExamHistoryService;

@Service
public class ExamHistoryServiceImpl implements ExamHistoryService{
	
	@Autowired
	private ExamHistoryRepo examHistoryRepo;

	@Override
	public ExamHistoryModel saveExamHistory(ExamHistoryModel examHistory) {
		return examHistoryRepo.save(examHistory);
	}

	@Override
	public ExamHistoryModel updateExamHistory(ExamHistoryModel examHistory) {
		ExamHistoryModel examHistoryResp = getExamHistoryById(examHistory.getExamHistoryId());
		if(examHistoryResp != null){
			return examHistoryRepo.save(examHistory);
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public ExamHistoryModel getExamHistoryById(Integer examHistoryById) {
		return examHistoryRepo.getOne(examHistoryById);
	}

	@Override
	public List<ExamHistoryModel> getAllExamHistory() {
		return examHistoryRepo.findAll();
	}

	@Override
	public void deleteExamHistory(Integer examHistoryById) {
		ExamHistoryModel examHistoryResp = getExamHistoryById(examHistoryById);
		if(examHistoryResp != null){
			examHistoryRepo.delete(examHistoryResp);
		}
	}
}
