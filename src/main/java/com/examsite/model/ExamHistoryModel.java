package com.examsite.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Table(name="exam_history")
public class ExamHistoryModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="exam_history_id")
	private Integer examHistoryId;
	
	@Column(name="email_id")
	private String emailId;
	
	@CreationTimestamp
	@Column(name="exam_date")
	private LocalDate examDate;
	
	@Column(name="no_of_questions_attempted")
	private Integer noOfQuestionsAttempted;
	
	@Column(name="actual_no_of_questions")
	private Integer actualNoOfQuestions;
	
	@Column(name="marks_gained")
	private Integer marksGained;
	
	@Column(name="exam_status")
	private String examStatus;
}
