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
	
	@Query(value="select * "
			+ "from exam_questions where question_id = "
			+ "(SELECT question_id FROM exam.active_exam_questions where exam_history_id = "
			+ "(SELECT exam_history_id FROM exam.exam_history "
			+ "where email_id = :emailId order by  1 desc limit 1) order by 1 asc limit 0,1);", nativeQuery = true)
	public Tuple getExamQuestionsByEmailId(@Param(value = "emailId") String emailId, Pageable pageRequest);
}
