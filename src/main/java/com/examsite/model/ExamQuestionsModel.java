package com.examsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Table(name="exam_questions")
public class ExamQuestionsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_id")
	private Integer questionId;
	
	@Column(name="question")
	private	String question;
	
	@Column(name="option_a")
	private	String optionA;
	
	@Column(name="option_b")
	private	String optionB;
	
	@Column(name="option_c")
	private	String optionC;
	
	@Column(name="option_d")
	private String optionD;
	
	@Column(name="answer")
	private String answer;
}
