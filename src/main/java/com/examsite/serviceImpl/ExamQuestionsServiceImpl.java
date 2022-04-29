package com.examsite.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.examsite.dto.ExamQuestionsByEmailIdDTO;
import com.examsite.dto.RandomExamQuestionsDTO;
import com.examsite.model.ActiveExamQuestionsModel;
import com.examsite.model.ExamHistoryModel;
import com.examsite.model.ExamQuestionsModel;
import com.examsite.repo.ActiveExamQuestionsRepo;
import com.examsite.repo.ExamHistoryRepo;
import com.examsite.repo.ExamQuestionsRepo;
import com.examsite.service.ExamQuestionsService;

@Service
public class ExamQuestionsServiceImpl implements ExamQuestionsService{
	
	@Autowired
	private ExamQuestionsRepo examQuestionsRepo;
	
	@Autowired
	private ExamHistoryRepo examHistoryRepo;
	
	@Autowired
	private ActiveExamQuestionsRepo activeExamQuestionsRepo;

	@Override
	public ExamQuestionsModel saveExamQuestions(ExamQuestionsModel examQuestions) {
		return examQuestionsRepo.save(examQuestions);
	}

	@Override
	public ExamQuestionsModel updateExamQuestions(ExamQuestionsModel examQuestions) {
		ExamQuestionsModel examQuestionsResp = getExamQuestionsById(examQuestions.getQuestionId());
		if(examQuestionsResp != null){
			return examQuestionsRepo.save(examQuestions);
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public ExamQuestionsModel getExamQuestionsById(Integer examQuestionsById) {
		return examQuestionsRepo.getOne(examQuestionsById);
	}

	@Override
	public List<ExamQuestionsModel> getAllExamQuestions() {
		return examQuestionsRepo.findAll();
	}
	
	
	@Override
	public void deleteExamQuestions(Integer examQuestionsById) {
		ExamQuestionsModel examQuestionsResp = getExamQuestionsById(examQuestionsById);
		if(examQuestionsResp != null){
			examQuestionsRepo.delete(examQuestionsResp);
		}
	}
	
	@Override
	public List<RandomExamQuestionsDTO> getRandomExamQuestions(){
		List<Tuple> tupleList = examQuestionsRepo.getRandomExamQuestions();
		List<RandomExamQuestionsDTO> resultList = new ArrayList<>();
		for(Tuple t:tupleList){
			resultList.add(new RandomExamQuestionsDTO(t));
		}
		return resultList;
	}

	@Override
	public String setupExamConfiguration(String emailId) {
		List<RandomExamQuestionsDTO> randomQuestionsList = getRandomExamQuestions();
		ExamHistoryModel examHistory = new ExamHistoryModel();
		examHistory.setEmailId(emailId);
		examHistory.setNoOfQuestionsAttempted(0);
		examHistory.setActualNoOfQuestions(randomQuestionsList.size());
		examHistory.setMarksGained(0);
		examHistory.setExamStatus("failed");
		examHistory = examHistoryRepo.save(examHistory);
		List<ActiveExamQuestionsModel> activeExamQuestionsList = new ArrayList<>();
		for(RandomExamQuestionsDTO randomQuestion: randomQuestionsList){
			ActiveExamQuestionsModel activeQuestion = new ActiveExamQuestionsModel();
			ExamQuestionsModel examQuestionsModel = new ExamQuestionsModel();
			examQuestionsModel.setQuestionId(randomQuestion.getQuestionId());
			activeQuestion.setQuestionId(examQuestionsModel);
			activeQuestion.setExamHistoryId(examHistory.getExamHistoryId());
			activeQuestion.setExamStatus("Test_started");
			activeExamQuestionsList.add(activeQuestion);
		}
		activeExamQuestionsRepo.saveAll(activeExamQuestionsList);
		return "exam_setup_completed";
	}

	@Override
	public void saveUserAnswer(String userAnswer, Integer questionId, String emailId) {
		Integer examHistoryId= examHistoryRepo.getExamHistroyIdByEmail(emailId);
		ActiveExamQuestionsModel activeExamQuestion = activeExamQuestionsRepo.getByQuestionIdAndExamHistoryId(questionId, examHistoryId);
		activeExamQuestion.setUserAnswer(userAnswer);
		activeExamQuestionsRepo.save(activeExamQuestion);
	}
	
	@Override
	public ExamQuestionsByEmailIdDTO getExamQuestionsByEmailId(String emailId, Pageable pageRequest) {
		Integer examHistoryId = examQuestionsRepo.getExamHistoryByEmailId(emailId);
		List<Integer> questionId = examQuestionsRepo.getQuestionIdByExamHistoryId(examHistoryId, pageRequest);
		List<Tuple> tupleList = examQuestionsRepo.getExamQuestionsByEmailId(questionId.get(0));
		ExamQuestionsByEmailIdDTO examQuestionsByEmailIdDTO = new ExamQuestionsByEmailIdDTO(tupleList.get(0));
		return examQuestionsByEmailIdDTO;
	}

	@Override
	public ExamHistoryModel validateExam(String emailId) {
		List<ExamHistoryModel> examHistory = examHistoryRepo.findByEmailIdOrderByExamHistoryIdDesc(emailId,PageRequest.of(0,1));
		List<ActiveExamQuestionsModel> activeExamQuestionsModelList = activeExamQuestionsRepo.getByExamHistoryId(examHistory.get(0).getExamHistoryId());
		Integer userAtemptedQuestionsCount = 0;
		Integer marksGained = 0;
		for(ActiveExamQuestionsModel activeExamQuestionsModel :activeExamQuestionsModelList) {
			if(null != activeExamQuestionsModel.getUserAnswer()) {
				userAtemptedQuestionsCount++;
				if(activeExamQuestionsModel.getUserAnswer().equals(activeExamQuestionsModel.getQuestionId().getAnswer())) {
					marksGained++;
				}
			}
		}
		Double percentage = (double) (marksGained.doubleValue()/examHistory.get(0).getActualNoOfQuestions().doubleValue())*100;
		System.out.println(percentage);
		String examStatus = percentage > 50?"Pass":"Fail";
		examHistory.get(0).setMarksGained(marksGained);
		examHistory.get(0).setNoOfQuestionsAttempted(userAtemptedQuestionsCount);
		examHistory.get(0).setExamStatus(examStatus);
		ExamHistoryModel examHistoryres = examHistoryRepo.save(examHistory.get(0));
		return examHistoryres;
	}
}
