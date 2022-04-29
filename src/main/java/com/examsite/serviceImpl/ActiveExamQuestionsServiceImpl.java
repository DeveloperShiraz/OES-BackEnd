package com.examsite.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examsite.model.ActiveExamQuestionsModel;
import com.examsite.repo.ActiveExamQuestionsRepo;
import com.examsite.service.ActiveExamQuestionsService;

@Service
public class ActiveExamQuestionsServiceImpl implements ActiveExamQuestionsService{
	
	@Autowired
	private ActiveExamQuestionsRepo activeExaQuestionsRepo;

	@Override
	public ActiveExamQuestionsModel saveActiveExamQuestions(ActiveExamQuestionsModel activeExamQuestions) {
		return activeExaQuestionsRepo.save(activeExamQuestions);
	}

	@Override
	public ActiveExamQuestionsModel updateActiveExamQuestions(ActiveExamQuestionsModel activeExamQuestions) {
		ActiveExamQuestionsModel activeExamQuestionsResp = getActiveExamQuestionsById(activeExamQuestions.getActiveExamQuestionId());
		if(activeExamQuestionsResp != null){
			return activeExaQuestionsRepo.save(activeExamQuestions);
		}
		return null;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public ActiveExamQuestionsModel getActiveExamQuestionsById(Integer activeExamQuestionsId) {
		return activeExaQuestionsRepo.getOne(activeExamQuestionsId);
	}

	@Override
	public List<ActiveExamQuestionsModel> getAllActiveExamQuestions() {
		return activeExaQuestionsRepo.findAll();
	}

	@Override
	public void deleteActiveExamQuestion(Integer activeExamQuestionsId) {
		ActiveExamQuestionsModel activeExamQuestionsResp = getActiveExamQuestionsById(activeExamQuestionsId);
		if(activeExamQuestionsResp != null){
			activeExaQuestionsRepo.delete(activeExamQuestionsResp);
		}
		
	}
}
