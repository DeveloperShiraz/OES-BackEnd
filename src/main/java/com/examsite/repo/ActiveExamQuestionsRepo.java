package com.examsite.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examsite.model.ActiveExamQuestionsModel;

@Repository
public interface ActiveExamQuestionsRepo extends JpaRepository<ActiveExamQuestionsModel, Integer>{
	public ActiveExamQuestionsModel getByQuestionIdAndExamHistoryId(Integer questionId,Integer examHistroyId);
	
	public List<ActiveExamQuestionsModel> getByExamHistoryId(Integer examHistroyId);
}
