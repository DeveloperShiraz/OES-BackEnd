package com.examsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Table(name = "active_exam_questions")
public class ActiveExamQuestionsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="active_exam_question_id")
	private Integer activeExamQuestionId;

	@OneToOne
	@JoinColumn(name="question_id")
	private ExamQuestionsModel questionId;

	@Column(name="exam_history_id")
	private Integer examHistoryId;

	@Column(name="exam_status")
	private String examStatus;
	
	@Column(name="user_answer")
	private String userAnswer;
}
