package com.examsite.repo;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examsite.model.ExamQuestionsModel;

public interface ExamQuestionsRepo extends JpaRepository<ExamQuestionsModel, Integer>{
	
	@Query(value="SELECT  *"
			+" FROM exam_questions eq"
			+" ORDER BY RAND()"
			+" LIMIT 5", nativeQuery = true)
	public List<Tuple> getRandomExamQuestions();
	
	@Query(value="select * from exam_questions where question_id = :questionId", nativeQuery = true)
	public List<Tuple> getExamQuestionsByEmailId(@Param(value = "questionId") Integer questionId);

	@Query(value="SELECT exam_history_id FROM exam_history where email_id = :emailId order by  1 desc limit 0,1",nativeQuery = true)
	public Integer getExamHistoryByEmailId(@Param(value = "emailId") String emailId);
	
	@Query(value="SELECT question_id FROM active_exam_questions where exam_history_id = :examHistoryId order by 1 asc",nativeQuery = true)
	public List<Integer> getQuestionIdByExamHistoryId(@Param(value = "examHistoryId") Integer examHistoryId, Pageable pageRequest);
}
