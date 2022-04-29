package com.examsite.dto;

import javax.persistence.Tuple;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class ExamQuestionsByEmailIdDTO {
	private Integer questionId;
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	public ExamQuestionsByEmailIdDTO(Tuple t){
		super();
		this.questionId = t.get(0, Integer.class);
		this.question = t.get(1, String.class);
		this.optionA = t.get(2, String.class);
		this.optionB = t.get(3, String.class);
		this.optionC = t.get(4, String.class);
		this.optionD = t.get(5, String.class);
	}
}