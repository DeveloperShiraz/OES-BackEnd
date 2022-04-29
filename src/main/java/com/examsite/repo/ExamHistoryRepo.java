package com.examsite.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examsite.model.ExamHistoryModel;

public interface ExamHistoryRepo extends JpaRepository<ExamHistoryModel, Integer>{

	@Query(value="SELECT exam_history_id FROM exam.exam_history where email_id = :emailId order by  1 desc limit 1", nativeQuery = true)
	public Integer getExamHistroyIdByEmail(@Param("emailId") String emailId);
}
